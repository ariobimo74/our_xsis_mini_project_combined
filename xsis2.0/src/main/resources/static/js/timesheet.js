$(() => {
    var rowperpage = 30;
    row_per_page("", "", rowperpage);

});
function row_per_page(start_date, end_date, rowperpage) {
    var $pagination = $('#pagination');
    if (start_date == "" && end_date == "") {
        $.ajax({
            url: "api/timesheet/",
            async: true,
            dataType: 'json',
            success: function (data) {
                document.getElementById('searchStartDate').value = "";
                document.getElementById('searchEndDate').value = "";
                $pagination.pagination({
                    dataSource: data,
                    pageSize: rowperpage,
                    showPageNumbers: false,
                    showNavigator: true,
                    callback: function (displayRecords, pagination) {
                        $('#tbRole').html('');
                        for (var i = 0; i < displayRecords.length; i++) {

                            if (displayRecords[i].userApproval == null) {
                                displayRecords[i].userApproval = "-";
                            }
                            if (displayRecords[i].eroStatus == null) {
                                displayRecords[i].eroStatus = "-";
                            }

                            if (displayRecords[i].userApproval == "Approved") {

                                tr = $('<tr class="product text-center">');
                                tr.append("<td>" + displayRecords[i].status + "</td>");
                                tr.append("<td>" + convertionDate(displayRecords[i].timesheetDate) + "</td>");
                                tr.append("<td>" + displayRecords[i].placementId.clientId.name + "</td>");
                                tr.append("<td>" + displayRecords[i].userApproval + "</td>");
                                tr.append("<td>" + displayRecords[i].eroStatus + "</td>");
                                tr.append('<td>\n' +
                                    '<div class="input-group-btn">\n' +
                                    '             <div class="dropdown show">\n' +
                                    '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> More </a>\n' +
                                    '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                                    '                 <a class="dropdown-item" onclick="detailAction(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#detailModal" href="#">Detail</a>\n' +
                                    '                 <a class="dropdown-item" onclick="deleteAction(\'' + displayRecords[i].id + '\',\'' + convertionDate(displayRecords[i].timesheetDate) + '\')">Hapus</a>\n' +
                                    '               </div>\n' +
                                    '             </div>\n' +
                                    '           </div>\n' +
                                    '</td>\n' +
                                    '</tr>')
                                $('#tbRole').append(tr);

                            } else {

                                tr = $('<tr class="product text-center">');
                                tr.append("<td>" + displayRecords[i].status + "</td>");
                                tr.append("<td>" + convertionDate(displayRecords[i].timesheetDate) + "</td>");
                                tr.append("<td>" + displayRecords[i].placementId.clientId.name + "</td>");
                                tr.append("<td>" + displayRecords[i].userApproval + "</td>");
                                tr.append("<td>" + displayRecords[i].eroStatus + "</td>");
                                tr.append('<td>\n' +
                                    '<div class="input-group-btn">\n' +
                                    '             <div class="dropdown show">\n' +
                                    '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> More </a>\n' +
                                    '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                                    '                 <a class="dropdown-item" onclick="detailAction(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#detailModal" href="#">Detail</a>\n' +
                                    '                 <a class="dropdown-item" onclick="editAction(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#editModal" id="showEditData" href="#">ubah</a>\n' +
                                    '                 <a class="dropdown-item" onclick="deleteAction(\'' + displayRecords[i].id + '\',\'' + convertionDate(displayRecords[i].timesheetDate) + '\')">Hapus</a>\n' +
                                    '               </div>\n' +
                                    '             </div>\n' +
                                    '           </div>\n' +
                                    '</td>\n' +
                                    '</tr>')
                                $('#tbRole').append(tr);

                            }


                        }
                    }
                });
            }
        });
    } else if (start_date != "" && end_date != "") {
        $.ajax({
            url: 'api/timesheet/searchDate?sd=' + start_date + '%2000:00&ed=' + end_date + '%2023:59',
            async: true,
            dataType: 'json',
            success: function (data) {
                $pagination.pagination({
                    dataSource: data,
                    pageSize: rowperpage,
                    showPageNumbers: false,
                    showNavigator: true,
                    callback: function (displayRecords, pagination) {
                        $('#tbRole').html('');
                        for (var i = 0; i < displayRecords.length; i++) {

                            if (displayRecords[i].userApproval == null) {
                                displayRecords[i].userApproval = "-";
                            }
                            if (displayRecords[i].eroStatus == null) {
                                displayRecords[i].eroStatus = "-";
                            }

                            if (displayRecords[i].userApproval == "Approved") {

                                tr = $('<tr class="product text-center">');
                                tr.append("<td>" + displayRecords[i].status + "</td>");
                                tr.append("<td>" + convertionDate(displayRecords[i].timesheetDate) + "</td>");
                                tr.append("<td>" + displayRecords[i].placementId.clientId.name + "</td>");
                                tr.append("<td>" + displayRecords[i].userApproval + "</td>");
                                tr.append("<td>" + displayRecords[i].eroStatus + "</td>");
                                tr.append('<td>\n' +
                                    '<div class="input-group-btn">\n' +
                                    '             <div class="dropdown show">\n' +
                                    '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> More </a>\n' +
                                    '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                                    '                 <a class="dropdown-item" onclick="detailAction(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#detailModal" href="#">Detail</a>\n' +
                                    '                 <a class="dropdown-item" onclick="deleteAction(\'' + displayRecords[i].id + '\',\'' + convertionDate(displayRecords[i].timesheetDate) + '\')">Hapus</a>\n' +
                                    '               </div>\n' +
                                    '             </div>\n' +
                                    '           </div>\n' +
                                    '</td>\n' +
                                    '</tr>')
                                $('#tbRole').append(tr);

                            } else {

                                tr = $('<tr class="product text-center">');
                                tr.append("<td>" + displayRecords[i].status + "</td>");
                                tr.append("<td>" + convertionDate(displayRecords[i].timesheetDate) + "</td>");
                                tr.append("<td>" + displayRecords[i].placementId.clientId.name + "</td>");
                                tr.append("<td>" + displayRecords[i].userApproval + "</td>");
                                tr.append("<td>" + displayRecords[i].eroStatus + "</td>");
                                tr.append('<td>\n' +
                                    '<div class="input-group-btn">\n' +
                                    '             <div class="dropdown show">\n' +
                                    '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> More </a>\n' +
                                    '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                                    '                 <a class="dropdown-item" onclick="detailAction(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#detailModal" href="#">Detail</a>\n' +
                                    '                 <a class="dropdown-item" onclick="editAction(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#editModal" id="showEditData" href="#">ubah</a>\n' +
                                    '                 <a class="dropdown-item" onclick="deleteAction(\'' + displayRecords[i].id + '\',\'' + convertionDate(displayRecords[i].timesheetDate) + '\')">Hapus</a>\n' +
                                    '               </div>\n' +
                                    '             </div>\n' +
                                    '           </div>\n' +
                                    '</td>\n' +
                                    '</tr>')
                                $('#tbRole').append(tr);

                            }


                        }
                    }
                });
            }
        });
    }
}

$(() => {
    get_client_name();
});
get_client_name = () => {
    $.ajax({
        url: 'api/client-name',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
            }
            $("#placementId").html(optValue);

        },
        error: function () {
            swal("", "Gagal Mengambil Data", "error");
        }
    })
}



$('#saveBtn').click(() => {

    var x = $('#overtime').val();
    if (x == "") {
        x = false;
    } else {
        x = x;
    }

    var start = $('#start').val();
    var A = $('#endTime').val();
    var B = $('#startOt').val();
    var endOt = $('#endOt').val();


    var data = {
        status: $('#status').val(),
        placementId: { id: $('#placementId').val() },
        timesheetDate: $('#timesheetDate').val(),
        start: $('#start').val(),
        endTime: $('#endTime').val(),
        overtime: x,
        startOt: $('#startOt').val(),
        endOt: $('#endOt').val(),
        activity: $('#activity').val()
    };
    if ($('#status').val() == "") {
        swal.fire("Status Tidak Boleh Kosong", "", "error");
    } else if ($('#timesheetDate').val() == "") {
        swal.fire("Tanggal Timesheet Tidak Boleh Kosong", "", "error");
    } else if ($('#status').val() == "Masuk" && $('#start').val() == "") {
        swal.fire("Jam Kerja Harus Terisi Lengkap", "", "error");
    } else if ($('#status').val() == "Masuk" && $('#endTime').val() == "") {
        swal.fire("Jam Kerja Harus Terisi Lengkap", "", "error");
    } else if (start > A) {
        swal.fire("Jam Kerja Salah / Tidak Sesuai", "", "error");
    } else if (B > endOt) {
        swal.fire("Jam Lembur Salah / Tidak Sesuai", "", "error");
    } else if (A > B) {
        swal.fire("Jam Mulai Lembur Tidak Sesuai", "", "error");
    } else {
        var tgl = $("#timesheetDate").val();
        $.ajax({
            url: "/api/timesheet",
            type: "get",
            contentType: "application/json",
            success: function (cek) {
                if (cek.length > 0) {
                    var result = false;
                    for (let i = 0; i < cek.length; i++) {
                        if (tgl == cek[i].timesheetDate) {
                            result = true;
                        }


                    }
                    if (result == false) {
                        $.ajax({
                            url: 'api/timesheet/',
                            type: 'post',
                            contentType: 'application/json',
                            data: JSON.stringify(data),
                            success: (res) => {
                                $('#addData').modal('hide');
                                swal.fire("Data Berhasil Disimpan ", "", "success");
                                $('#formData input[type=text]').val("");
                                $('#formData input[type=date]').val("");
                                $('#formData input[type=time]').val("");
                                $('#formData textarea[type=text]').val("");
                                row_per_page("", "", 50);
                            },
                            error: () => {
                                swal.fire("Data Gagal Disimpan", "", "error")
                            }
                        })
                    } else {
                        swal.fire("", "Timesheet pada tanggal tersebut sudah ada", "warning");
                    }
                } else {
                    $.ajax({
                        url: 'api/timesheet/',
                        type: 'post',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        success: (res) => {
                            $('#addData').modal('hide');
                            swal.fire("Data Berhasil Disimpan ", "", "success");
                            $('#formData input[type=text]').val("");
                            $('#formData input[type=date]').val("");
                            $('#formData input[type=time]').val("");
                            $('#formData textarea[type=text]').val("");
                            row_per_page("", "", 50);
                        },
                        error: () => {
                            swal.fire("Data Gagal Disimpan", "", "error")
                        }
                    })
                }
            }
        });


    }
})



$('#showAddData').click(() => {
    $('#formData')[0].reset();
    $('#placementId').attr('disabled', true);
    $('#start').attr('disabled', true);
    $('#endTime').attr('disabled', true);
    $('#startOt').attr('disabled', true);
    $('#endOt').attr('disabled', true);
})


$('#resetBtn').click(() => {
    $('#formData')[0].reset();
    $('#addData').modal('hide');
})

$('#status').on('change', function () {
    var x = $('#status').val();
    var y = $('#timesheetDate').val();
    if (x == "Masuk" && y == "") {
        $('#start').attr('disabled', true);
        $('#endTime').attr('disabled', true);
        $('#startOt').attr('disabled', true);
        $('#endOt').attr('disabled', true);
    } else if (x == "Masuk" && y != "") {
        $('#start').attr('disabled', false);
        $('#endTime').attr('disabled', false);
        $('#overtime').attr('disabled', false);
        $('#startOt').attr('disabled', true);
        $('#endOt').attr('disabled', true);
    } else {
        $('#start').attr('disabled', true);
        $('#endTime').attr('disabled', true);
        $('#start').val("");
        $('#endTime').val("");
        $('#overtime').val("");
        $('#startOt').attr('disabled', true);
        $('#endOt').attr('disabled', true);
    }
})

$('#overtime').on('change', function () {
    var x = $('#overtime').val();
    if (x == "true") {
        $('#startOt').attr('disabled', false);
        $('#endOt').attr('disabled', false);
    } else {
        $('#startOt').attr('disabled', true);
        $('#endOt').attr('disabled', true);
    }
})

$('#timesheetDate').on('change', function () {
    var x = $('#timesheetDate').val();
    var y = $('#status').val();
    if (x != "" && y == "Masuk") {
        $('#start').attr('disabled', false);
        $('#endTime').attr('disabled', false);
        $('#overtime').attr('disabled', false);
    } else {
        $('#start').attr('disabled', true);
        $('#endTime').attr('disabled', true);
        $('#overtime').attr('disabled', true);
        $('#start').val("");
        $('#endTime').val("");
        $('#overtime').val("");
    }
})

function detailAction(id) {

    $.ajax({
        url: 'api/timesheet/' + id,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {

            if (res.startOt == null) {
                res.startOt = "";
            }
            if (res.endOt == null) {
                res.endOt = "";
            }

            if (res.eroStatus == null) {
                res.eroStatus = "-";
            }
            if (res.userApproval == null) {
                res.userApproval = "-";
            }

            if (res.overtime == true) {
                res.overtime = "Ya";
            } else {
                res.overtime = "Tidak";
            }

            var time = res.start + " - " + res.endTime;
            var timeOt = res.startOt + " - " + res.endOt;


            $("#timesheetDetailId").html("");
            $("#dStatus").html("");
            $("#dClientName").html("");
            $("#dTimesheetDate").html("");
            $("#dTime").html("");
            $("#dActivity").html("");
            $("#dOvertime").html("");
            $("#dTimeOvertime").html("");
            $("#dUserApproval").html("");
            $("#dSubmittedOn").html("");
            $("#dApprovedOn").html("");
            $("#dEroStatus").html("");
            $("#dSentOn").html("");
            $("#dCollectedOn").html("");


            $("#timesheetDetailId").append(res.id);
            $("#dStatus").append(res.status);
            $("#dClientName").append(res.placementId.clientId.name);
            $("#dTimesheetDate").append(convertionDate(res.timesheetDate));
            $("#dTime").append(time);
            $("#dOvertime").append(res.overtime);
            $("#dTimeOvertime").append(timeOt);
            $("#dUserApproval").append(res.userApproval);
            $("#dEroStatus").append(res.eroStatus);
            $("#dSubmittedOn").append(convertionDate(res.submittedOn));
            $("#dApprovedOn").append(convertionDate(res.approvedOn));
            $("#dSentOn").append(convertionDate(res.sentOn));
            $("#dCollectedOn").append(convertionDate(res.collectedOn));
            $("#dActivity").text(res.activity);


        },
        error: () => {
            console.log("error fetch data")
        }
    })
}

function editAction(id) {

    //$('#editData')[0].reset();
    $("#ePlacementId").attr('disabled', true);

    $.ajax({
        url: 'api/timesheet/' + id,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {

            if (res.startOt == null) {
                res.startOt = "";
            }
            if (res.endOt == null) {
                res.endOt = "";
            }

            if (res.status == "Masuk") {
                $('#eStart').attr('disabled', false);
                $('#eEndTime').attr('disabled', false);
                $('#eOvertime').attr('disabled', false);
                $('#eStartOt').attr('disabled', true);
                $('#eEndOt').attr('disabled', true);
                $('#eActivity').attr('disabled', false);
            } else {
                $('#eStart').attr('disabled', true);
                $('#eEndTime').attr('disabled', true);
                $('#eOvertime').attr('disabled', true);
                $('#eStartOt').attr('disabled', true);
                $('#eEndOt').attr('disabled', true);
                $('#eActivity').attr('disabled', true);
            }

            var xy = res.overtime;
            var z = "";
            if (xy == true) {
                //z = true;
                var optValue = "";
                optValue += '<option value="">- Ya/Tidak -</option>';
                optValue += '<option value="true" selected="selected">Ya</option>';
                optValue += '<option value="false">Tidak</option>';
                $("#eOvertime").html(optValue);
            } else {
                //z = false;
                var optValue = "";
                optValue += '<option value="">- Ya/Tidak -</option>';
                optValue += '<option value="true">Ya</option>';
                optValue += '<option value="false" selected="selected">Tidak</option>';

                $("#eOvertime").html(optValue);
            }



            $("#timesheetEditId").val(res.id);
            $("#eUserApproval").val(res.userApproval);
            $("#eStatus").val(res.status);
            $("#eTimesheetDate").val(res.timesheetDate);
            $("#eStart").val(res.start);
            $("#eEndTime").val(res.endTime);
            $("#eStartOt").val(res.startOt);
            $("#eEndOt").val(res.endOt);
            $("#eActivity").val(res.activity);
            $.ajax({
                url: 'api/client-name',
                type: 'get',
                contentType: "application/json",
                success: function (result) {
                    var result = result[0];
                    var optValue = "";
                    optValue += `<option value="${result.id}">${result.name}</option>`;
                    $("#ePlacementId").html(optValue);

                },
                error: function () {
                    swal("", "Gagal Mengambil Data", "error");
                }
            })


        },
        error: () => {
            console.log("error fetch data")
        }
    })
}


$('#eStatus').on('change', function () {
    var x = $('#eStatus').val();
    if (x == "Masuk") {
        $('#eStart').attr('disabled', false);
        $('#eEndTime').attr('disabled', false);
        $('#eOvertime').attr('disabled', false);
        $('#eStartOt').attr('disabled', true);
        $('#eEndOt').attr('disabled', true);
    } else {
        $('#eStart').attr('disabled', true);
        $('#eEndTime').attr('disabled', true);
        $('#eStart').val("");
        $('#eEndTime').val("");
        $('#eOvertime').attr('disabled', true);
        $('#eOvertime').val("");
        $('#eStartOt').attr('disabled', true);
        $('#eEndOt').attr('disabled', true);
    }
})

$('#eOvertime').on('change', function () {
    var x = $('#eOvertime').val();
    if (x == "true") {
        $('#eStartOt').attr('disabled', false);
        $('#eEndOt').attr('disabled', false);
    } else {
        $('#eStartOt').attr('disabled', true);
        $('#eEndOt').attr('disabled', true);
        $('#eStartOt').val("");
        $('#eEndOt').val("");
    }
})

$('#eTimesheetDate').on('change', function () {
    var x = $('#eTimesheetDate').val();
    if (x != "") {
        $('#eStart').attr('disabled', false);
        $('#eEndTime').attr('disabled', false);
        $('#eOvertime').attr('disabled', false);
    } else {
        $('#eStart').attr('disabled', true);
        $('#eEndTime').attr('disabled', true);
        $('#eOvertime').attr('disabled', true);
    }
})


$('#editBtn').click(() => {

    var x = $('#eOvertime').val();
    if (x == "") {
        x = false;
    } else {
        x = x;
    }

    var start = $('#eStart').val();
    var A = $('#eEndTime').val();
    var B = $('#eStartOt').val();
    var endOt = $('#eEndOt').val();
    var data = {
        id: $('#timesheetEditId').val(),
        userApproval: $('#eUserApproval').val(),
        status: $('#eStatus').val(),
        placementId: { id: $('#ePlacementId').val() },
        timesheetDate: $('#eTimesheetDate').val(),
        start: $('#eStart').val(),
        endTime: $('#eEndTime').val(),
        overtime: x,
        startOt: $('#eStartOt').val(),
        endOt: $('#eEndOt').val(),
        activity: $('#eActivity').val()
    };
    if ($('#eStatus').val() == "") {
        swal.fire("Status Tidak Boleh Kosong", "", "error");
    } else if ($('#eTimesheetDate').val() == "") {
        swal.fire("Tanggal Timesheet Tidak Boleh Kosong", "", "error");
    } else if ($('#eStatus').val() == "Masuk" && $('#eStart').val() == "") {
        swal.fire("Jam Kerja Harus Terisi Lengkap", "", "error");
    } else if ($('#eStatus').val() == "Masuk" && $('#eEndTime').val() == "") {
        swal.fire("Jam Kerja Harus Terisi Lengkap", "", "error");
    } else if (start > A) {
        swal.fire("Jam Kerja Salah / Tidak Sesuai", "", "error");
    } else if (B > endOt) {
        swal.fire("Jam Lembur Salah / Tidak Sesuai", "", "error");
    } else if (A > B) {
        swal.fire("Jam Mulai Lembur Tidak Sesuai", "", "error");
    } else {
        var tgl = $("#eTimesheetDate").val();
        var id = $("#timesheetEditId").val();
        $.ajax({
            url: "/api/timesheet",
            type: "get",
            contentType: "application/json",
            success: function (cek) {
                if (cek.length > 0) {
                    var result = false;
                    for (let i = 0; i < cek.length; i++) {
                        if (tgl == cek[i].timesheetDate) {
                            result = true;
                        }
                        if (id == cek[i].id && tgl == cek[i].timesheetDate) {
                            result = false;
                        }


                    }
                    if (result == false) {
                        $.ajax({
                            url: 'api/timesheet/',
                            type: 'put',
                            contentType: 'application/json',
                            data: JSON.stringify(data),
                            success: (res) => {
                                $('#editModal').modal('hide');
                                swal.fire("Data Berhasil Disimpan ", "", "success");
                                $('#formData input[type=text]').val("");
                                $('#formData input[type=date]').val("");
                                $('#formData input[type=time]').val("");
                                $('#formData textarea[type=text]').val("");
                                row_per_page("", "", 50);
                            },
                            error: () => {
                                swal.fire("Data Gagal Disimpan", "", "error")
                            }
                        })
                    } else {
                        swal.fire("", "Timesheet pada tanggal tersebut sudah ada", "warning");
                    }
                }
            }
        });
    }
})


function deleteAction(id, name) {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
        title: 'Hapus Role ?',
        text: "Anda yakin ingin menghapus timesheet Tanggal " + name + " ?",
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/timesheet/' + id,
                type: 'delete',
                contentType: 'application/json',
                success: () => {

                    swal.fire("Timesheet Berhasil Dihapus ", "", "success");
                    row_per_page("", "", 30);
                },
            })
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your data file is safe :)',
                'error'
            )
            row_per_page("", "", 30);
        }
    })

}


// function getFormData($form) {
//     var unindexed_array = $form.serializeArray();
//     var indexed_array = {};
//     $.map(unindexed_array, function (n, i) {
//         indexed_array[n['name']] = n['value'];
//     });
//     return indexed_array;
// }

$(function () {
    $("#searchStartDate").daterangepicker({
        autoUpdateInput: true,
        singleDatePicker: true,
        showDropdowns: true,
        minYear: 1980,
        locale: {
            format: "YYYY-MM-DD"
        }
    });
});

$("#searchStartDate").on("change", function () {
    var mindts = $("#searchStartDate").val();
    setmindate_kapan2(mindts);
});

function setmindate_kapan2(min) {
    $("#searchEndDate").daterangepicker({
        autoUpdateInput: true,
        singleDatePicker: true,
        showDropdowns: true,
        minDate: min,
        locale: {
            format: "YYYY-MM-DD"
        }
    });
}

function convertionDate(get_date) {
    if (get_date == null) {

        return "-";

    } else {
        var tahun = get_date.toString().substr(0, 4);
        var bulan = get_date.toString().substr(5, 2);
        var tanggal = get_date.toString().substr(8, 2);

        if (bulan == "01") {
            bulan = "January";
        } else if (bulan == "02") {
            bulan = "February";
        } else if (bulan == "03") {
            bulan = "March";
        } else if (bulan == "04") {
            bulan = "April";
        } else if (bulan == "05") {
            bulan = "Mei";
        } else if (bulan == "06") {
            bulan = "June";
        } else if (bulan == "07") {
            bulan = "July";
        } else if (bulan == "08") {
            bulan = "August";
        } else if (bulan == "09") {
            bulan = "September";
        } else if (bulan == "10") {
            bulan = "October";
        } else if (bulan == "11") {
            bulan = "November";
        } else {
            bulan = "December";
        }
        var show = "";
        show = bulan + " " + tanggal + ", " + tahun;

        return show;
    }

}


function dataShowAsc() {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("tableTimesheet");
    switching = true;
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[0];
            y = rows[i + 1].getElementsByTagName("TD")[0];
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

function dataShowDesc() {
    var table, rows, switching, i, x, y, shouldSwitch;
    table = document.getElementById("tableTimesheet");
    switching = true;
    while (switching) {
        switching = false;
        rows = table.rows
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[0];
            y = rows[i + 1].getElementsByTagName("TD")[0];
            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                shouldSwitch = true;
                break;
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        }
    }
}

//Start Sorting
// function sortList(dir) {
//     var $products = $('.products .product');
//     var sorted = _.sortBy($products, function (product) {
//         return $(product).find('#sortDate').html();
//     });
//     if (dir == "desc") {
//         sorted.reverse();
//     }
//     $('.products').append($(sorted));
// }

// $('#asc').click(function () {
//     sortList('asc');
// });


// $('#desc').click(function () {
//     sortList('desc');
// });
//End Sorting




$('#btn-search').click(() => {

    if ($('#searchStartDate').val() == "" && $('#searchEndDate').val() == "") {
        swal.fire("", "Masukkan Tanggal Search", "warning");

    } else {
        var startDate = $("#searchStartDate").val();
        var endDate = $("#searchEndDate").val();

        row_per_page(startDate, endDate, 97);

    }
})

$('#btn-reset').click(() => {
    var x = document.getElementById("show_pagination");
    x.style.display = "block";
    $('#searchStartDate').val("");
    $('#searchEndDate').val("");
    var a = $('#searchStartDate').val();
    var b = $('#searchEndDate').val();
    row_per_page(a, b, 100);
})

$('#data-show-10').on('click', function () {
    var startDate = $("#searchStartDate").val();
    var endDate = $("#searchEndDate").val();

    row_per_page(startDate, endDate, 1);

});

$('#data-show-20').on('click', function () {
    var startDate = $("#searchStartDate").val();
    var endDate = $("#searchEndDate").val();

    row_per_page(startDate, endDate, 2);
});

$('#data-show-30').on('click', function () {
    var startDate = $("#searchStartDate").val();
    var endDate = $("#searchEndDate").val();

    row_per_page(startDate, endDate, 3);
});

$('#data-show-40').on('click', function () {
    var startDate = $("#searchStartDate").val();
    var endDate = $("#searchEndDate").val();

    row_per_page(startDate, endDate, 4);
});

$('#data-show-50').on('click', function () {
    var startDate = $("#searchStartDate").val();
    var endDate = $("#searchEndDate").val();

    row_per_page(startDate, endDate, 5);
});

// $('.get_checkbox').on('change', function () {
//     $('.get_checkbox').not(this).prop('checked', false);
// });

