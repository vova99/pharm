$(document).ready( function () {

    $('#admin-products-table').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Russian.json"
        },
        "lengthMenu": [ [25, 50, -1], [25, 50, "Все"] ],
        "order": [ 0, "desc" ],
        "autoWidth": false,
        "columnDefs": [
            // {
            //     "targets": [ 0 ],
            //     "visible": false,
            //     "searchable": false,
            // },
            {
                "targets": -1,
                "orderable": false,
                "searchable": false,
                "width": "100px"
            }
        ]
    });


});
