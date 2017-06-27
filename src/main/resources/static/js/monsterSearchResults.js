SearchResults = {

buildPage: function(data){


console.log(JSON.stringify(data));
var testData = [{name: 'name1', value: 'value1'},{name: 'name2', value: 'value2'}];

$('#monstersearchresultsTableHolder').DataTable( {

    data: data,
    columns: [
        { data: 'name' },
        { data: 'cr'},
        { data: 'xpValue'},
        { data: 'pageNumber'},
        { data: 'type'},

    ]
} );

}
}