SearchResults = {

    table: {},

    startup: function() {

        this.table = $('#monstersearchresultsTableHolder').DataTable( {

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

        this.table.clear().rows.add(data).draw();

    }
}