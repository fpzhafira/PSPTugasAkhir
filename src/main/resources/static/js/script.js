function findInArray(arr, search_key, search_criteria)
{
    var result = [];

    for (var i = 0; i < arr.length; i++)
        if(arr[i][search_key] === search_criteria) result.push(arr[i]);
    
    return result;
}

function parseJsonObj(json_obj)
{
    return JSON.parse(JSON.stringify(json_obj));
}