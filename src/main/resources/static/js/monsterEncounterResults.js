EncounterSearchResults = {

    table: {},

    startup: function() {


        this.table = $('#encounterSearchResultsMonsterTableHolder').DataTable( {
            columns: [
                { data: 'name' },
                { data: 'cr'},
                { data: 'xpValue'},
                { data: 'pageNumber'},
                { data: 'type'}
            ]
        } );
    },

    buildPage: function(data) {

        console.log(JSON.stringify(data));

        var monsterList = data.encounterMonsterList

        this.table.clear().rows.add(monsterList).draw();

    }
}