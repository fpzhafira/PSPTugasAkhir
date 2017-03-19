package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;

@Mapper
public interface TermMapper {

	@Select("SELECT * FROM term WHERE id_term=#{idTerm}")
	@Results(value = {
			@Result(property="idTerm", column="id_term"),
			@Result(property="years", column="term_year"),
			@Result(property="termHeld", column="term_Held")
	})
	TermModel selectTerm(String idTerm);
	
	@Select("SELECT term_year, term_Held FROM term WHERE term_year=#{year} AND term_Held=#{termHeld}")
	@Results(value = {
			@Result(property="years", column="term_year"),
			@Result(property="termHeld", column="term_Held")
	})
	TermModel selectTermByYearAndTermHeld(@Param("year") String year, @Param("termHeld") String termHeld);
		
	@Select("SELECT * FROM term")
	@Results(value = {
			@Result(property="idTerm", column="id_term"),
			@Result(property="years", column="term_year"),
			@Result(property="termHeld", column="term_Held")
	})
	List<TermModel> selectAllTerms();
	
	@Insert("INSERT INTO term (term_year, term_Held) VALUES (#{years}, #{termHeld})")
	void createTerm(TermModel term);
	
	@Update("UPDATE term SET term_year=#{years}, term_Held=#{termHeld} "
			+ "WHERE id_term=#{idTerm}")
	void updateTerm(TermModel term);
	
	@Update("UPDATE term SET flag_active='0' WHERE id_term=#{idTerm}")
	void deleteTerm(String idTerm);
}
