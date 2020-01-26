var year = []
var month = []

$(() => {
    get_marriage_year();
    var rowperpage = 10;
    loadData("", rowperpage);
});
function loadData(pelamar, rowperpage) {
    if (pelamar != "") {
        var x = document.getElementById("show_icon1");
        x.style.display = "block";
        var y = document.getElementById("show_icon2");
        y.style.display = "block";
        var $pagination = $('#pagination');
        $.ajax({
            url: 'api/biodata/search?pelamar=' + pelamar,
            type: 'get',
            contentType: 'application/json',
            success: (res) => {
                if (res.length <= 0) {
                    var x1 = document.getElementById("show_icon1");
                    x1.style.display = "none";
                    var y1 = document.getElementById("show_icon2");
                    y1.style.display = "none";
                    var z1 = document.getElementById("show_pagination");
                    z1.style.display = "none";
                    var x = document.getElementById("showList");
                    x.style.display = "block";
                    $('#showList').html("");
                    var data_not_found =
                        '<div class="row">\n' +
                        '<div class="col-md-12 text-center align-middle">\n' +
                        '<img src="../../images/not_found.png" width="200" height="200">\n' +
                        '</div>\n' +
                        '</div>'
                    $('#showList').append(data_not_found);
                } else {
                    var x = document.getElementById("showList");
                    x.style.display = "block";
                    var x1 = document.getElementById("show_icon1");
                    x1.style.display = "block";
                    var y1 = document.getElementById("show_icon2");
                    y1.style.display = "block";
                    var z1 = document.getElementById("show_pagination");
                    z1.style.display = "block";
                    $pagination.pagination({
                        dataSource: res,
                        pageSize: rowperpage,
                        showPageNumbers: false,
                        showNavigator: true,
                        callback: function (displayRecords, pagination) {
                            $('#showList').html("");
                            for (var i = 0; i < displayRecords.length; i++) {
                                var div =
                                    '<div class="card bg-light text-dark product">\n' +
                                    '<div class="searchable-container">\n' +
                                    '<div class="items col-xs-12 col-sm-12 col-md-12 col-lg-12 mb-3 clearfix">\n' +
                                    '    <div class="info-block block-info clearfix">\n' +
                                    '    <h4 id="sortFullName"><strong>' + displayRecords[i].fullName + '</strong></h4>\n' +
                                    '    <div class="row">\n' +
                                    '        <div class="col-md-2">\n' +
                                    '              <p>Nama Panggilan</p>\n' +
                                    '        </div>\n' +
                                    '       <div class="col-md-3">\n' +
                                    '              <p class="text-left"><strong>' + displayRecords[i].nickName + '</strong></p>\n' +
                                    '        </div>\n' +
                                    '    </div>\n' +
                                    '   <div class="row">\n' +
                                    '        <div class="col-md-2">\n' +
                                    '              <p>Email</p>\n' +
                                    '        </div>\n' +
                                    '        <div class="col-md-3">\n' +
                                    '              <p class="text-left"><strong>' + displayRecords[i].email + '</strong></p>\n' +
                                    '        </div>\n' +
                                    '        <div class="col-md-7">\n' +
                                    '             <div class="align-right text-right" style="margin-right:30px;">\n' +
                                    '                 <a onclick="get_id_biodata(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#detailVacancy" href="#" id="showDetailVacancy"><i class="fa fa-search" aria-hidden="true"></i></a>\n' +
                                    '                 <a onclick="get_id_biodata_token(' + displayRecords[i].id + ')" data-toggle="modal" data-target="#sendToken" href="#"><i class="fa fa-envelope"></i></a>\n' +
                                    '             </div>\n' +
                                    '        </div>\n' +
                                    '    </div>\n' +
                                    '    <div class="row">\n' +
                                    '        <div class="col-md-2">\n' +
                                    '             <p>No. Handphone</p>\n' +
                                    '       </div>\n' +
                                    '        <div class="col-md-3">\n' +
                                    '              <p class="text-left"><strong>' + displayRecords[i].phoneNumber1 + '</strong></p>\n' +
                                    '        </div>\n' +
                                    '    </div>\n' +
                                    '    <div class="row">\n' +
                                    '        <div class="col-md-2">\n' +
                                    '              <p>Pendidikan</p>\n' +
                                    '        </div>\n' +
                                    '        <div class="col-md-5">\n' +
                                    '              <p class="text-left"><strong>' + getdatalastmajor(displayRecords[i].id) + ', ' + getdatalastschool(displayRecords[i].id) + '</strong></p>\n' +
                                    '        </div>\n' +
                                    '    </div>\n' +
                                    '</div>\n' +
                                    '</div>\n' +
                                    '</div>\n' +
                                    '</div>'
                                $('#showList').append(div);
                            }
                        }
                    });
                }
            },
            error: () => {
                swal.fire("Error!", "Fetch Biodata Failed", "error");
            }
        })
    } else {
        var x = document.getElementById("showList");
        x.style.display = "none";
        var x1 = document.getElementById("show_icon1");
        x1.style.display = "block";
        var y1 = document.getElementById("show_icon2");
        y1.style.display = "block";
        var z1 = document.getElementById("show_pagination");
        z1.style.display = "none";
    }
}

// Start Validation
// (function () {
//   'use strict';
//   window.addEventListener('load', function () {
//     var forms = document.getElementsByClassName('needs-validation');
//     var validation = Array.prototype.filter.call(forms, function (form) {
//       form.addEventListener('submit', function (event) {
//         if (form.checkValidity() === false) {
//           event.preventDefault();
//           event.stopPropagation();
//         }
//         form.classList.add('was-validated');
//       }, false);
//     });
//   }, false);
// })();
// End Validation

//Start Row Per Page
$('#rowperpage_1').click(function () {
    var search = $('#temp-input-search').val();
    loadData(search, 1);
});

$('#rowperpage_2').click(function () {
    var search = $('#temp-input-search').val();
    loadData(search, 2);
});

$('#rowperpage_3').click(function () {
    var search = $('#temp-input-search').val();
    loadData(search, 3);
});

$('#rowperpage_4').click(function () {
    var search = $('#temp-input-search').val();
    loadData(search, 4);
});

$('#rowperpage_5').click(function () {
    var search = $('#temp-input-search').val();
    loadData(search, 5);
});
//End Row Per Page

//Start Sorting
function sortList(dir) {
    var $products = $('.products .product');
    var sorted = _.sortBy($products, function (product) {
        return $(product).find('#sortFullName').html();
    });
    if (dir == "desc") {
        sorted.reverse();
    }
    $('.products').append($(sorted));
}

$('#asc').click(function () {
    sortList('asc');
});


$('#desc').click(function () {
    sortList('desc');
});
//End Sorting

function getdatalastmajor(id) {
    var data_major = "";
    $.ajax({
        url: 'api/education/last/' + id,
        type: 'get',
        contentType: "application/json",
        async: false,
        success: function (result) {
            result.map((data2) => {
                data_major = data2.major
            })
        },
        error: function () {
            swal.fire("Error!", "Fetch Last Education Failed", "error");
        }
    })
    if (data_major == null || data_major == "") {
        data_major = "-";
    }
    return data_major;
}

function getdatalastschool(id) {
    var data_schoolName = "";
    $.ajax({
        url: 'api/education/last/' + id,
        type: 'get',
        contentType: "application/json",
        async: false,
        success: function (result) {
            result.map((data2) => {
                data_schoolName = data2.schoolName

            })
        },
        error: function () {
            swal.fire("Error!", "Fetch Last Education Failed", "error");
        }
    })
    if (data_schoolName == null || data_schoolName == "") {
        data_schoolName = "-";
    }
    return data_schoolName;
}

// $('#detailVacancy').on('show.bs.modal', function () {
//   $('#list-profile-list').addClass("active");
//   $('#list-profile').addClass("show active");
// })

// $('#showDetailVacancy').click(() => {
//   $('#list-pendidikan-list').removeClass("active");
//   $('#list-pendidikan').removeClass("show active");

//   $('#list-profile-list').addClass("active");
//   $('#list-profile').addClass("show active");
// });

$('#detailVacancy').on('hidden.bs.modal', function () {

    // $('#list-profile-list').removeClass("active");
    // $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");
});

$('#addData').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-pendidikan-list').addClass("active");
    $('#list-pendidikan').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#editData').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-pendidikan-list').addClass("active");
    $('#list-pendidikan').addClass("show active");

    $('#detailVacancy').modal('show');
});

//Start Search Pelamar
$("#input-search").on("keydown", function (e) {
    var search = $('#input-search').val();
    var x = document.getElementById("show_pagination");
    x.style.display = "none";
    var y1 = document.getElementById("show_icon1");
    y1.style.display = "none";
    var y2 = document.getElementById("show_icon2");
    y2.style.display = "none";
    var z = document.getElementById("showList");
    z.style.display = "none";
    if (e.which == 13) {
        $('#temp-input-search').val(search);
        loadData(search, 10);
    }
});

$('#searchNamaPelamar').click(function () {
    var search = $('#input-search').val();
    if (search == "") {
        swal.fire("Error!", "Please Fill The Column First", "error");
    } else {
        $('#temp-input-search').val(search);
        loadData(search, 10);
    }
});
//End Search Pelamar

//Start Reset Search Pelamar
$('#resetNamaPelamar').click(function () {
    $('#input-search').val("");
    loadData("", 10);
});

// $("#input-search").keyup(function () {
//   var input = $(this);
//   if (input.val() == "") {
//     loadData("", 10);
//   }
// });

const isEmpty = str => !str.trim().length;
document.getElementById("input-search").addEventListener("input", function () {
    // var x = document.getElementById("showList");
    // x.style.display = "block";
    var x = document.getElementById("loading_gif");
    if (isEmpty(this.value)) {
        x.style.display = "none";
        loadData(this.value, 10);
    } else {
        x.style.display = "block";
        var x = document.getElementById("showList");
        x.style.display = "block";
    }
});
//End Reset Search Pelamar

$('#showAddData').click(() => {
    $('#addData').modal('show');
    $('#detailVacancy').modal('hide');
    $('#formAddData input[type=text]').val("");
    $('#formAddData input[type=number]').val("");
    $('#formAddData textarea[type=text]').val("");
    var temp = "";
    $("#educationLevelId").val(temp);
    $("#entryYear").val(temp);
    $("#graduationYear").val(temp);
})

$(() => {
    get_entry_year();
});
get_entry_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#entryYear").html(value_year);
}


$(() => {
    get_graduation_year();
});
get_graduation_year = () => {
    $(document).ready(function () {
        $('#entryYear').on('change', function () {
            var j = this.value;
            var current_year = new Date();
            var year = current_year.getFullYear();
            var value_year = "";
            value_year += '<option value="">- Pilih -</option>';
            if (this.value == "") {
            } else {
                while (j <= year) {
                    value_year += `<option value="` + j + `">` + j + `</option>`;
                    j++;
                }
            }
            $("#graduationYear").html(value_year);
        });
    });
}



$(() => {
    eget_entry_year();
});
eget_entry_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#eentryYear").html(value_year);

}

$(() => {
    eget_graduation_year();
});
eget_graduation_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    var j = 1990;
    while (j <= year) {
        value_year += `<option value="` + j + `">` + j + `</option>`;
        j++;
    }
    $("#egraduationYear").html(value_year);
}

$(() => {
    get_education_level();
});
get_education_level = () => {
    $.ajax({
        url: 'api/education-level',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">- Pilih -</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
            }
            $("#educationLevelId").html(optValue);

        },
        error: function () {
            swal.fire("Error!", "Fetch Education Level Failed", "error");
        }
    })
}

function gender(gender) {
    if (gender == true) {
        return "Laki-Laki";
    } else {
        return "Perempuan";
    }
}

function age(dob) {
    var today = new Date();
    var birthday = new Date(dob);
    var year = 0;
    if (today.getMonth() < birthday.getMonth()) {
        year = 1;
    } else if ((today.getMonth() == birthday.getMonth()) && today.getDate() < birthday.getDate()) {
        year = 1;
    }
    var age = today.getFullYear() - birthday.getFullYear() - year;
    if (age < 0) {
        age = 0;
    }
    return age;
}

function totaldurationcertificate(traiYear, traiDuration, traiPeriodId) {
    if (traiPeriodId == 1) { //If Type Period Year
        var total = 0;
        var ty = parseInt(traiYear);
        total = ty + traiDuration;
    } else {
        total = traiYear;
    }
    return total;
}


function get_id_biodata(id) {
    $('#uname').val("");
    $('#pass').val("");
    $('#state').val("");
    detailData(id);

    $('#bioidKe').val(id);
    $('#bioidCat').val(id);
    $('#bioidKel').val(id);

    $('#list-profile-list').addClass("active");
    $('#list-profile').addClass("show active");

    // Start Last Periode
    $.ajax({
        url: 'api/onlineTest/lastPeriod?biodataId=' + id,
        type: 'get',
        contentType: 'application/json',
        success: (res39) => {
            if (res39.length > 0) {
                res39.map((res99) => {
                    if (res99.status == "Proses") {
                        $('#state').val("Aktif");
                    } else {
                        $('#state').val("Tidak Aktif");
                    }
                })
            } else {
                $('#state').val("");
            }
        }
    })
    // End Last Periode

    $.ajax({
        url: 'api/biodata/' + id,
        type: 'get',
        contentType: 'application/json',
        success: (res1) => {
            $("#biodataId").val(id);

            // Addrbook Check Username
            $('#bioId').val(id);
            $('#biodId').val(id);
            $('#email').val(res1.email);
            $('#namaorang').val(res1.fullName);
            if (res1.addrbookId == "" || res1.addrbookId == null) {
            } else {
                $.ajax({
                    url: 'api/addressBook/' + res1.addrbookId,
                    type: 'get',
                    contentType: 'application/json',
                    success: (res7) => {
                        $('#uname').val(res7.abuid);
                        $('#pass').val(res7.abpwd);
                    },
                    error: () => {
                        swal.fire("Error!", "Fetch Addrbook Error", "error");
                    }
                })
            }
            // Addrbook Check Username

            // Start List Dokumen
            $.ajax({
                url: 'api/dokumen/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res1) => {
                    $('#tbDokumen').html("");
                    res1.map((data) => {
                        var note;
                        if (data.notes == null) {
                            note = "-";
                        } else {
                            note = data.notes;
                        }
                        var vacancyId = data.id;
                        var actions = '<div class="input-group-btn">\n' +
                            '             <div class="dropdown show">\n' +
                            '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Action </a>\n' +
                            '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                            '                 <a class="dropdown-item" onclick="get_id_dokumen_edit(' +
                            vacancyId + ')" data-toggle="modal" data-target="#EditDoc">Edit</a>\n' +
                            '                 <a class="dropdown-item" onclick="get_id_dokumen_delete(\'' +
                            vacancyId + '\',\'' + data.fileName + '\',\'' + id + '\')">Delete</a>\n' +
                            '            </div>\n' +
                            '             </div>\n' +
                            '        </div>'
                        var markup = "<tr class='text-center'><td>" + data.fileName + "</td><td>" + note +
                            "</td><td class='align-middle text-center'>" +
                            actions + "</td></tr>"
                        $('#tbDokumen').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Dokumen", "error");
                }
            })
            // End List Dokument

            // Start List Organisasi
            $("#biodataIdOrganisasi").val(id);
            $.ajax({
                url: 'api/organisasi/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res2) => {
                    $('#tbOrganisasi').html("");
                    res2.map((data) => {
                        var vacancyId = data.id;
                        var actions = '<div class="input-group-btn">\n' +
                            '             <div class="dropdown show">\n' +
                            '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Action </a>\n' +
                            '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                            '                 <a class="dropdown-item" onclick="get_id_organisasi_edit(' +
                            vacancyId + ')" data-toggle="modal" data-target="#editDataOrg">Edit</a>\n' +
                            '                 <a class="dropdown-item" onclick="get_id_organisasi_delete(\'' +
                            vacancyId + '\',\'' + data.name + '\',\'' + id + '\')">Delete</a>\n' +
                            '            </div>\n' +
                            '             </div>\n' +
                            '        </div>'
                        var markup = "<tr class='text-center'><td>" + data.name + "</td><td>" + data.position +
                            "</td><td>" + data.entry_year + " s.d " + data.exit_year +
                            "</td><td class='align-middle text-center'>" +
                            actions + "</td></tr>"
                        $('#tbOrganisasi').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Organisasi", "error");
                }
            })
            // Start List Organisasi

            // Get Last Periode
            $.ajax({
                url: 'api/onlineTest/lastPeriod?biodataId=' + id,
                type: 'get',
                contentType: 'application/json',
                success: function (res5) {
                    var k = document.getElementById("aktifasi");
                    if (res5.length > 0) {
                        res5.map((rest) => {
                            if (rest.status == "Selesai") {
                                if (k.innerHTML == "Non-Aktifkan") {
                                    k.innerHTML = "Aktifkan";
                                }
                            } else {
                                if (k.innerHTML == "Aktifkan") {
                                    k.innerHTML = "Non-Aktifkan";
                                }
                            }
                        })
                    } else {
                        k.innerHTML = "Aktifkan";
                    }
                }
            })
            // Get Last Periode

            // Start List Online Test
            $.ajax({
                url: 'api/onlineTest/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res3) => {
                    $('#tbAktifasi').html("");
                    res3.map((data) => {
                        var onlineTestId = data.id;
                        var sts = data.status;
                        var actions = '<div class="input-group-btn">\n' +
                            '             <div class="dropdown show">\n' +
                            '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Action </a>\n' +
                            '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                            '                 <a class="dropdown-item" onclick="get_type_test(' +
                            onlineTestId +
                            ')" data-toggle="modal" data-target="#EditTest">Tampilkan Pilihan Tes</a>\n' +
                            '                 <a class="dropdown-item" onclick="get_onlineTest_delete(\'' +
                            onlineTestId + '\',\'' + data.periodeCode + '\',\'' + id + '\')">Delete</a>\n' +
                            '            </div>\n' +
                            '             </div>\n' +
                            '        </div>'
                        var markup = "<tr class='text-center'><td>" + data.periodeCode + "</td><td>" + data
                            .period +
                            "</td><td>" + data.testDate + "</td><td>" + data.expiredTest +
                            "</td><td>" + data.userAccess + "</td><td>" + data.status +
                            "</td><td class='align-middle text-center'>" +
                            actions + "</td></tr>"
                        $('#tbAktifasi').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Online Test", "error");
                }
            })
            // End List Online Test

            // Start List Pelatihan
            $.ajax({
                url: 'api/pelatihan/period/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res) => {
                    $('#tbPelatihan').html("");
                    res.map((data) => {
                        $('#biodataId3').val(id);

                        var timeperiod = "";
                        var nameperiod = "";

                        if (data.trainingDuration == null) {
                            timeperiod = "";
                        } else {
                            timeperiod = data.trainingDuration;
                        }

                        if (data.name == null) {
                            nameperiod = "-";
                        } else {
                            nameperiod = data.name;
                        }

                        var periodtraining = timeperiod + " " + nameperiod

                        var actions = '<div class="input-group-btn">\n' +
                            '             <div class="dropdown show">\n' +
                            '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Action </a>\n' +
                            '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                            '                 <a class="dropdown-item" onclick="get_id_pelatihan_edit(' + data.id + ')" data-toggle="modal" data-target="#editDataPelatihan">Edit</a>\n' +
                            '                 <a class="dropdown-item" onclick="get_id_pelatihan_delete(\'' + data.id + '\',\'' + data.trainingName + '\',\'' + id + '\')">Delete</a>\n' +
                            '            </div>\n' +
                            '             </div>\n' +
                            '        </div>'
                        var markup = "<tr class='text-center'><td>" + data.trainingName + "</td><td>" + data.organizer + "</td><td>" + data.trainingYear + " - " + data.trainingMonth + "</td><td>" + periodtraining + "</td><td class='align-middle text-center'>" + actions + "</td></tr>"
                        $('#tbPelatihan').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Pelatihan", "error");
                }
            })

            // End List Pelatihan


            $.ajax({
                url: 'api/biodata-attachment/profile/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (result) => {
                    $('#showPhoto').html("");

                    if (result.fileName == null || result.fileName == "") {
                        var showPhotoProfile =
                            '<img src="../../images/icon_profile.jpg" style="width:130px;height:130px;">'
                    } else {
                        var imgurl = result.filePath + result.fileName;
                        var showPhotoProfile =
                            '<img src="' + imgurl + '" style="width:130px;height:130px;">'
                    }
                    $('#showPhoto').append(showPhotoProfile);

                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Image Failed", "error");
                }
            })

            $('#showProfile1').html("");
            var setShowProfile1 =
                '     <h3><strong>' + res1.fullName + '</strong></h3>\n' +
                '     <h5>' + age(res1.dob) + ' Tahun</h5>\n' +
                '     <h5>' + gender(res1.gender) + '</h5>'

            $('#showProfile1').append(setShowProfile1);

            $.ajax({
                url: 'api/education/last/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (result1) => {
                    $('#showProfile2').html("");
                    if (result1.length < 1) {
                        var sett1 =
                            '     <h5>-, -</h5>'
                        $('#showProfile2').append(sett1);
                    } else {
                        result1.map((datares1) => {
                            var sett1 =
                                '     <h5>' + datares1.major + ', ' + datares1.schoolName + '</h5>'
                            $('#showProfile2').append(sett1);
                        })
                    }
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Last Education Failed", "error");
                }
            })

            // Start List Education
            $.ajax({
                url: 'api/education/level/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res2) => {
                    $('#showListPendidikan').html("");
                    res2.map((data2) => {
                        if (data2.entryYear == "" || data2.entryYear == null) {
                            data2.entryYear = "";
                        }
                        if (data2.graduationYear == "" || data2.graduationYear == null) {
                            data2.graduationYear = "";
                        }
                        if (data2.major == "" || data2.major == null) {
                            data2.major = "-";
                        }
                        if (data2.gpa == "" || data2.gpa == null || data2.gpa == 0) {
                            data2.gpa = "-";
                        }
                        if (data2.entryYear == data2.graduationYear) {
                            if (data2.entryYear == "" || data2.entryYear == null) {
                                data2.entryYear = "-";
                                var set2 =
                                    '<div class="row">\n' +
                                    '   <div class="col-md-2">\n' +
                                    '      <p>' + data2.entryYear + '</p>\n' +
                                    '   </div>\n' +
                                    '   <div class="col-md-10">\n' +
                                    '      <h6><strong>' + data2.schoolName + ', ' + data2.country + '</strong></h6>\n' +
                                    '      <h6><strong>' + data2.major + '</strong></h6>\n' +
                                    '      <h6><strong>' + data2.gpa + '</strong></h6>\n' +
                                    '   </div>\n' +
                                    '</div>'
                            }
                        } else {
                            var set2 =
                                '<div class="row">\n' +
                                '   <div class="col-md-2">\n' +
                                '      <p>' + data2.entryYear + ' - ' + data2.graduationYear + '</p>\n' +
                                '   </div>\n' +
                                '   <div class="col-md-10">\n' +
                                '      <h6><strong>' + data2.schoolName + ', ' + data2.country + '</strong></h6>\n' +
                                '      <h6><strong>' + data2.major + '</strong></h6>\n' +
                                '      <h6><strong>' + data2.gpa + '</strong></h6>\n' +
                                '   </div>\n' +
                                '</div>'
                        }

                        $('#showListPendidikan').append(set2)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Education by Id Biodata Failed", "error");
                }
            })
            // End List Education

            // Start List Pengalaman Kerja
            $.ajax({
                url: 'api/pengalaman-kerja/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res3) => {
                    $('#showListPengalaman').html("");
                    res3.map((data3) => {
                        if (data3.joinYear == 0 || data3.joinYear == "" || data3.joinYear == null) {
                            data3.joinYear == "";
                        }
                        if (data3.resignYear == 0 || data3.resignYear == "" || data3.resignYear == null) {
                            data3.resignYear == "";
                        }
                        if (data3.lastPosition == "" || data3.lastPosition == null) {
                            data3.lastPosition == "";
                        }
                        if (data3.companyName == "" || data3.companyName == null) {
                            data3.companyName == "";
                        }
                        if (data3.joinYear == data3.resignYear) {
                            var set3 =
                                '<div class="row">\n' +
                                '   <div class="col-md-2">\n' +
                                '        <p>' + data3.joinYear + '</p>\n' +
                                '   </div>\n' +
                                '   <div class="col-md-10">\n' +
                                '        <h6><strong>' + data3.lastPosition + '</strong></h6>\n' +
                                '        <h6><strong>' + data3.companyName + '</strong></h6>\n' +
                                '   </div>\n' +
                                '</div>'
                        } else {
                            var set3 =
                                '<div class="row">\n' +
                                '   <div class="col-md-2">\n' +
                                '        <p>' + data3.joinYear + ' - ' + data3.resignYear + '</p>\n' +
                                '   </div>\n' +
                                '   <div class="col-md-10">\n' +
                                '        <h6><strong>' + data3.lastPosition + '</strong></h6>\n' +
                                '        <h6><strong>' + data3.companyName + '</strong></h6>\n' +
                                '   </div>\n' +
                                '</div>'
                        }
                        $('#showListPengalaman').append(set3)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Pengalaman Kerja by Id Biodata Failed", "error");
                }
            })
            // Start List Pengalaman Kerja

            // Start List Keterampilan/Keahlian
            var set4_1 = "";
            var set4_2 = "";
            var set4_3 = "";
            $.ajax({
                url: 'api/keahlian/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res4) => {
                    var coma = ", ";
                    var set4_1a = "";
                    var set4_2a = "";
                    var set4_3a = "";
                    $('#keterampilanL1').html("");
                    $('#keterampilanL2').html("");
                    $('#keterampilanL3').html("");
                    for (var i = 0; i < res4.length; i++) {
                        if (res4[i].skillLevelId == 1) {
                            set4_1 += res4[i].skillName + coma;
                        }
                        if (res4[i].skillLevelId == 2) {
                            set4_2 += res4[i].skillName + coma;
                        }
                        if (res4[i].skillLevelId == 3) {
                            set4_3 += res4[i].skillName + coma;
                        }
                    }

                    set4_1a = set4_1.slice(0, set4_1.length - 2);
                    set4_2a = set4_2.slice(0, set4_2.length - 2);
                    set4_3a = set4_3.slice(0, set4_3.length - 2);

                    if (set4_1a == "") {
                        set4_1a = "-";
                    }
                    if (set4_2a == "") {
                        set4_2a = "-";
                    }
                    if (set4_3a == "") {
                        set4_3a = "-";
                    }
                    var set4_1_1 = '<p><strong>' + set4_1a + ' </strong></p>'
                    var set4_1_2 = '<p><strong>' + set4_2a + ' </strong></p>'
                    var set4_1_3 = '<p><strong>' + set4_3a + ' </strong></p>'
                    $('#keterampilanL1').append(set4_1_1);
                    $('#keterampilanL2').append(set4_1_2);
                    $('#keterampilanL3').append(set4_1_3);
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Pengalaman Kerja by Id Biodata Failed", "error");
                }
            })
            // End List Keterampilan/Keahlian

            // Start List Training
            $.ajax({
                url: 'api/training/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res5) => {
                    var v_totaldurationcertificate = 0;
                    $('#showListTraining').html("");
                    res5.map((data5) => {
                        v_totaldurationcertificate = totaldurationcertificate(data5.trainingYear, data5.trainingDuration, data5.timePeriodId);
                        if (data5.trainingYear == 0 || data5.trainingYear == "" || data5.trainingYear == null) {
                            data5.trainingYear == "";
                        }
                        if (data5.trainingName == 0 || data5.trainingName == "" || data5.trainingName == null) {
                            data5.trainingName == "";
                        }
                        if (data5.organizer == 0 || data5.organizer == "" || data5.organizer == null) {
                            data5.organizer == "";
                        }
                        if (v_totaldurationcertificate == 0 || v_totaldurationcertificate == "" || v_totaldurationcertificate == null) {
                            v_totaldurationcertificate == "";
                        }
                        if (data5.trainingYear == v_totaldurationcertificate) {
                            var set5 =
                                '<div class="row">\n' +
                                '  <div class="col-md-2">\n' +
                                '     <p>' + v_totaldurationcertificate + '</p>\n' +
                                '  </div>\n' +
                                '  <div class="col-md-10">\n' +
                                '     <h6><strong>' + data5.trainingName + '</strong></h6>\n' +
                                '     <h6><strong>' + data5.organizer + '</strong></h6>\n' +
                                '  </div>\n' +
                                '</div>'
                        } else {
                            var set5 =
                                '<div class="row">\n' +
                                '  <div class="col-md-2">\n' +
                                '     <p>' + data5.trainingYear + ' - ' + v_totaldurationcertificate + '</p>\n' +
                                '  </div>\n' +
                                '  <div class="col-md-10">\n' +
                                '     <h6><strong>' + data5.trainingName + '</strong></h6>\n' +
                                '     <h6><strong>' + data5.organizer + '</strong></h6>\n' +
                                '  </div>\n' +
                                '</div>'
                        }

                        $('#showListTraining').append(set5)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Sertifikasi by Id Biodata Failed", "error");
                }
            })
            // Start List Training

            // Start List Sertifikasi
            $.ajax({
                url: 'api/sertifikasi/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res6) => {
                    $('#showListSertifikasi').html("");
                    res6.map((data6) => {
                        if (data6.validStartYear == 0 || data6.validStartYear == "" || data6.validStartYear == null) {
                            data6.validStartYear == "";
                        }
                        if (data6.untilYear == 0 || data6.untilYear == "" || data6.untilYear == null) {
                            data6.untilYear == "";
                        }
                        if (data6.certificateName == "" || data6.certificateName == null) {
                            data6.certificateName == "";
                        }
                        if (data6.publisher == "" || data6.publisher == null) {
                            data6.publisher == "";
                        }
                        var set6 =
                            '<div class="row">\n' +
                            '   <div class="col-md-2">\n' +
                            '       <p>' + data6.validStartYear + ' - ' + data6.untilYear + '</p>\n' +
                            '   </div>\n' +
                            '   <div class="col-md-10">\n' +
                            '       <h6><strong>' + data6.certificateName + '</strong></h6>\n' +
                            '       <h6><strong>' + data6.publisher + '</strong></h6>\n' +
                            '   </div>\n' +
                            '</div>'
                        $('#showListSertifikasi').append(set6)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Sertifikasi by Id Biodata Failed", "error");
                }
            })
            // End List Sertifikasi

            // Start Pendidikan
            $.ajax({
                url: 'api/education/level/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res) => {
                    $('#tbEducation').html("");
                    res.map((data) => {
                        if (data.entryYear == "" || data.entryYear == null) {
                            data.entryYear = "-";
                        }
                        if (data.graduationYear == "" || data.graduationYear == null) {
                            data.graduationYear = "-";
                        }
                        if (data.major == "" || data.major == null) {
                            data.major = "-";
                        }
                        if (data.gpa == "" || data.gpa == null || data.gpa == 0) {
                            data.gpa = "-";
                        }
                        var actions = '<div class="input-group-btn">\n' +
                            '             <div class="dropdown show">\n' +
                            '                 <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Action </a>\n' +
                            '            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n' +
                            '                 <a class="dropdown-item" onclick="get_id_education_edit(' + data.id + ')" data-toggle="modal" data-target="#editData">Edit</a>\n' +
                            '                 <a class="dropdown-item" onclick="get_id_education_delete(\'' + data.id + '\',\'' + data.schoolName + '\',\'' + id + '\')">Delete</a>\n' +
                            '            </div>\n' +
                            '             </div>\n' +
                            '        </div>'
                        if (data.entryYear == data.graduationYear) {
                            var markup = "<tr class='text-center'><td>" + data.schoolName + "</td><td>" + data.name + "</td><td>" + data.entryYear + "</td><td>" + data.major + "</td><td>" + data.gpa + "</td><td class='align-middle text-center'>" + actions + "</td></tr>"
                        } else {
                            var markup = "<tr class='text-center'><td>" + data.schoolName + "</td><td>" + data.name + "</td><td>" + data.entryYear + " s.d " + data.graduationYear + "</td><td>" + data.major + "</td><td>" + data.gpa + "</td><td class='align-middle text-center'>" + actions + "</td></tr>"
                        }
                        $('#tbEducation').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Education Failed", "error");
                }
            })
            // End Pendidikan

            // Start List Catatan
            $.ajax({
                url: 'rest/catatan/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res) => {
                    $('#tbCat').html("");
                    res.map((data) => {
                        var actions = '<div class="input-group-btn">' +
                            '            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Action' +
                            '                </button>' +
                            '            <ul class="dropdown-menu">' +
                            '                <li><button class="btn btn-warning nBtn" onclick="showEditFormCat(this.value)" value="' + data.id + '">Edit</button></li>' +
                            '                <li><button class="btn btn-danger nBtn" onclick="deleteActionCat(this)" value=' + data.id + '>Delete</button></li>\n' +
                            '            </ul>\n' +
                            '        </div>'
                        var markup = "<tr><td class='text-center'>" + data.title + "</td><td class='text-center'>" + data.name + "</td><td class='text-center'>" + data.fullname + "</td><td class='text-center'>" + actions + "</td></tr>"
                        $('#tbCat').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Catatan", "error");
                }
            })
            // End List Catatan

            // Start List Keluarga
            $.ajax({
                url: 'rest/keluarga/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res) => {
                    $('#tbKel').html("");
                    res.map((data) => {
                        var jk = "";
                        if (data.gender == true) {
                            jk = "Pria";
                        } else {
                            jk = "Wanita";
                        }
                        var tgl = "";
                        if (data.dob == null) {
                            tgl = "-";
                        } else {
                            tgl = data.dob;
                        }
                        var edu = "";
                        if (data.educationName == "Choose...") {
                            edu = "-";
                        } else {
                            edu = data.educationName;
                        }
                        var actions = '<div class="input-group-btn">' +
                            '            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Action' +
                            '                </span></button>' +
                            '            <ul class="dropdown-menu">' +
                            '                <li><button class="btn btn-warning nBtn" onclick="showEditFormKel(this.value)" value="' + data.id + '">Edit</button></li>' +
                            '                <li><button class="btn btn-danger nBtn" onclick="deleteActionKe(this)" value=' + data.id + '>Delete</button></li>\n' +
                            '            </ul>\n' +
                            '        </div>'
                        var markup = "<tr><td class='text-center'>" + data.hubungan + "</td><td class='text-center'>" + data.name + "</td><td class='text-center'>" + jk + "</td><td class='text-center'>" + tgl + "</td><td class='text-center'>" + edu + "</td><td class='text-center'>" + data.job + "</td><td class='text-center'>" + actions + "</td></tr>"
                        $('#tbKel').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Keluarga", "error");
                }
            })
            // End List Keluarga

            // Start List Keahlian
            $.ajax({
                url: 'rest/keahlian/biodata/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (res) => {
                    $('#tbKe').html("");
                    res.map((data) => {
                        var actions = '<div class="input-group-btn">' +
                            '            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Action' +
                            '                </span></button>' +
                            '            <ul class="dropdown-menu">' +
                            '                <li><button class="btn btn-warning nBtn" onclick="showEditFormKe(this.value)" value="' + data.id + '">Edit</button></li>' +
                            '                <li><button class="btn btn-danger nBtn" onclick="deleteActionKe(this)" value=' + data.id + '>Delete</button></li>\n' +
                            '            </ul>\n' +
                            '        </div>'
                        var markup = "<tr><td class='text-center'>" + data.skillName + "</td><td class='text-center'>" + data.name + "</td><td class='text-center'>" + actions + "</td></tr>"
                        $('#tbKe').append(markup)
                    })
                },
                error: () => {
                    swal.fire("Error!", "Fetch Data Keahlian", "error");
                }
            })
            // End List Keahlian

            // Start List Pengalaman Kerja
            $.ajax({
                url: 'api/alfia/pengalamankerja/bio/' + id,
                type: 'get',
                contentType: 'application/json',
                success: (result) => {
                    $("#tbPengker").html("");
                    if (result.length > 0) {
                        for (var i = 0; i < result.length; i++) {
                            idPengKer = result[i].id;
                            if (result[i].notes == null) {
                                var notes = "-";
                            } else {
                                var notes = result[i].notes;
                            }
                            var ubah = `ubah`;
                            var hapus = `hapus`;
                            var tambah = `tambah`;
                            $("#tbPengker").append(
                                "<tr>" +
                                "<td>" + result[i].companyName + " (" + result[i].joinYear + "-" + result[i].joinMonth + " s/d " + result[i].resignYear + "-" + result[i].resignMonth + ")" +
                                "<div id=\"tbProyek" + idPengKer + "\">" +
                                "</div>" +
                                "</td>" +
                                "<td>" + notes + "</td>" +
                                "<td>" +
                                "<div class=\"btn-group\">" +
                                "<button type=\"button\" class=\"btn btn-info\">More</button>" +
                                "<button type=\"button\" class=\"btn btn-info dropdown-toggle\" data-toggle=\"dropdown\">" +
                                "<span class=\"caret\"></span>" +
                                "<span class=\"sr-only\">Toggle Dropdown</span>" +
                                "</button>" +
                                "<ul class=\"dropdown-menu\" role=\"menu\">" +
                                "<li class=\"nav - item has - treeview menu - open\"><a class=\"dropdown - item text - center\" onclick=\"get_data_peker_by_id(" + result[i].id + ", `ubah`)\" >Ubah</a></li>" +
                                "<li class=\"nav - item has - treeview menu - open\"><a class=\"dropdown - item  text - center\" onclick=\"deleteData(" + result[i].id + ", `hapus`)\" >Hapus</a></li>" +
                                "<liclass=\"nav - item has - treeview menu - oipen\"><a class=\"dropdown - item  text - center\" onclick=\"get_data_peker_by_id(" + result[i].id + ", `tambah`)\" >Tambah Project</a></li>" +
                                "</ul>" +
                                "</div>" +
                                "</td>" +
                                "</tr>"
                            );
                            month[i] = result[i].joinMonth;
                            year[i] = result[i].joinYear;
                        }
                        for (var k = 0; k < result.length; k++) {
                            var idPengalamanKerja = result[k].id;
                            $.ajax({
                                url: 'api/alfia/proyek/pengkerAll/' + idPengalamanKerja,
                                type: 'get',
                                contentType: 'application/json',
                                success: (result1) => {
                                    $("#tbProyek" + idPengalamanKerja).html("");
                                    if (result1.length > 0) {
                                        for (var j = 0; j < result1.length; j++) {
                                            if (result1[j].description == null) {
                                                var desc = "-";
                                            } else {
                                                var desc = result1[j].description;
                                            }
                                            var markup =
                                                "<ul>" +
                                                "<li>" +
                                                "<b>" + result1[j].projectName + " (" + result1[j].startYear + "-" + result1[j].startMonth + " ; " + result1[j].projectDuration + " " + result1[j].name + ")" +
                                                "<a data-toggle=\"modal\" data-target=\"#editModal\" href=\"#\" id=\"editProyek\">" +
                                                "<i class=\"fa fa-edit\" aria-hidden=\"true\"></i></a>" +
                                                "<a onclick=\"deleteProyek(" + id + "," + result1[j].id + ")\">" +
                                                "<i class=\"fa fa-trash-alt\" aria-hidden=\"true\"></i></a>" +
                                                "</b>" +
                                                "</li>" +
                                                "<p style=\"margin:0px;\">" + result1[j].projectPosition + ", " + result1[j].client + "</p>" +
                                                "<p>Ket:" + desc + "</p>" +
                                                "</ul>"
                                            $("#tbProyek" + result1[j].riwayatPekerjaanId).append(markup);
                                        }
                                    } else {
                                        $("#tbProyek" + result1[j].riwayatPekerjaanId).html("");
                                    }
                                },
                                error: function () {
                                    swal.fire("Error!", "Fetch Data Pengalaman Kerja All", "error");
                                }
                            });
                        }
                    } else {
                        $("#tbPengker").html("<tr><td colspan='4' style='text-align:center'>Data Was Not Found</i></td></tr>")
                    }
                },
                error: function () {
                    swal.fire("Error!", "Fetch Data Pengalaman Kerja", "error");
                }
            })
            // End List Pengalaman Kerja

            // Start List Sertifikasi 
            $.ajax({
                url: 'api/alfia/sertifikasi/bio/' + id,
                type: 'get',
                contentType: 'application/json',
                success: function (result) {
                    $("#tbSertif").html("");
                    if (result.length > 0) {
                        for (var i = 0; i < result.length; i++) {
                            if (result[i].until_year == null && result[i].until_month == null) {
                                var until = "-";
                            } else {
                                var until = result[i].until_year + "-" + result[i].until_month;
                            }

                            $("#tbSertif").append(
                                "<tr>" +
                                "<td>" + result[i].certificate_name + "</td>" +
                                "<td>" + result[i].publisher + "</td>" +
                                "<td>" + result[i].valid_start_year + "-" + result[i].valid_start_month + " s.d " + until + "</td>" +
                                "<td>" +
                                "<div class=\"btn-group\">" +
                                "<button type=\"button\" class=\"btn btn-info\">More</button>" +
                                "<button type=\"button\" class=\"btn btn-info dropdown-toggle\" data-toggle=\"dropdown\">" +
                                "<span class=\"caret\"></span>" +
                                "<span class=\"sr-only\">Toggle Dropdown</span>" +
                                "</button>" +
                                "<ul class=\"dropdown-menu\" role=\"menu\">" +
                                "<li><a onclick=\"get_data_by_id(" + result[i].id + ", 'edit')\" data-toggle='modal' data-target='#addDataSertifikasi'>Ubah</a></li>" +
                                "<li><a onclick=\"hapus(" + result[i].biodataId + "," + result[i].id + ")\">Hapus</a></li>" +
                                "</ul>" +
                                "</div>" +
                                "</td>" +
                                "</tr>");
                        }
                    } else {
                        $("#tbSertif").html("<tr><td colspan='4' style='text-align:center'>Data Was Not Found</i></td></tr>")
                    }
                },
                error: function () {
                    swal.fire("Error!", "Fetch Data Sertifikasi", "error");
                }
            })
            // End List Sertifikasi

            // Start List Referensi
            $.ajax({
                url: 'api/alfia/referensi/bio/' + id,
                type: 'get',
                contentType: 'application/json',
                success: function (result) {
                    $("#tbReferensi").html("");
                    if (result.length > 0) {
                        for (var i = 0; i < result.length; i++) {
                            $("#tbReferensi").append(
                                "<tr>" +
                                "<td>" + result[i].name + "</td>" +
                                "<td>" + result[i].address_phone + "</td>" +
                                "<td>" + result[i].position + "</td>" +
                                "<td>" + result[i].relation + "</td>" +
                                "<td>" +
                                "<div class=\"btn-group\">" +
                                "<button type=\"button\" class=\"btn btn-info\">More</button>" +
                                "<button type=\"button\" class=\"btn btn-info dropdown-toggle\" data-toggle=\"dropdown\">" +
                                "<span class=\"caret\"></span>" +
                                "<span class=\"sr-only\">Toggle Dropdown</span>" +
                                "</button>" +
                                "<ul class=\"dropdown-menu\" role=\"menu\">" +
                                "<li><a onclick=\"get_data_ref_by_id(" + result[i].biodataId + "," + result[i].id + ", 'edit')\" data-toggle='modal' data-target='#addRefe'>Ubah</a></li>" +
                                "<li><a onclick=\"hapusrefe(" + result[i].biodataId + "," + result[i].id + ")\">Hapus</a></li>" +
                                "</ul>" +
                                "</div>" +
                                "</td>" +
                                "</tr>");
                        }
                    } else {
                        $("#tbReferensi").html("<tr><td colspan='5' style='text-align:center'>Data Was Not Found</i></td></tr>")
                    }
                },
                error: function () {
                    swal.fire("Error!", "Fetch Data Referensi", "error");
                }
            })
            // End List Referensi

            // Start Keterangan Tambahan
            $.ajax({
                url: 'api/alfia/keterangantambahan/bio/' + id,
                type: 'get',
                contentType: 'application/json',
                success: function (result) {
                    if (result == null || result == "") {
                        $("#idketam").val("");
                        $("#salary").html("");
                        $("#salary").append('<td>-</td>');
                        $("#nego").html("");
                        var coba = "";
                        if (result == null || result == "") {
                            $("#nego").append('<td>-</td>');
                        }
                        $("#readyToWork").html("");
                        $("#readyToWork").append('<td>-</td>');
                        $("#readyToOutoftown").html("");
                        if (result == null || result == "") {
                            $("#readyToOutoftown").append('<td>-</td>');
                        }
                        $("#emergencyName").html("");
                        $("#emergencyName").append('<td>-</td>');
                        $("#emergencyCall").html("");
                        $("#emergencyCall").append('<td>-</td>');
                    } else {
                        $("#idketam").val(result.id);
                        $("#salary").html("");
                        $("#salary").append('<td>' + result.expected_salary + '</td>');
                        $("#nego").html("");
                        var coba = result.is_negotiable;
                        if (result.is_negotiable == true) {
                            $("#nego").append('<td>Ya</td>');
                        } else {
                            $("#nego").append('<td>Tidak</td>');
                        }
                        $("#readyToWork").html("");
                        $("#readyToWork").append('<td>' + result.start_working + '</td>');
                        $("#readyToOutoftown").html("");
                        if (result.is_ready_to_outoftown == true) {
                            $("#readyToOutoftown").append('<td>Ya</td>');
                        } else {
                            $("#readyToOutoftown").append('<td>Tidak</td>');
                        }
                        $("#emergencyName").html("");
                        $("#emergencyName").append('<td>' + result.emergency_contact_name + '</td>');
                        $("#emergencyCall").html("");
                        $("#emergencyCall").append('<td>' + result.emergency_contact_phone + '</td>');
                    }

                },
                error: function () {
                    swal.fire("Error!", "Fetch Data Keterangan Tambahan", "error");
                }
            })
            // End Keterangan Tambahan
        },
        error: () => {
            swal.fire("Error!", "Fetch Biodata Detail Failed", "error");
        }
    })
}

function get_id_education_delete(vacancyId, schoolName, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
        title: 'Hapus Pendidikan ?',
        text: "Anda yakin ingin menghapus pendidikan di " + schoolName + " ?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/education/' + vacancyId,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(id);

                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-pendidikan-list').addClass("active");
                    $('#list-pendidikan').addClass("show active");

                    swalWithBootstrapButtons.fire(
                        'Deleted!',
                        'Your data has been deleted.',
                        'success'
                    )
                    $('#detailVacancy').modal('show');
                },
            })
        } else if (
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your data file is safe :)',
                'error'
            )

            get_id_biodata(id);

            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-pendidikan-list').addClass("active");
            $('#list-pendidikan').addClass("show active");

            $('#detailVacancy').modal('show');
        }
    })
}

function showTAorSkripsi(educationLevel) {
    if (educationLevel > 4) {
        $("#egradSchool1").show();
        $("#egradSchool2").show();
    } else {
        $("#egradSchool1").hide();
        $("#egradSchool2").hide();
    }
}


function get_id_education_edit(vacancyId) {
    $('#detailVacancy').modal('hide');
    $.ajax({
        url: 'api/education/' + vacancyId,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {
            $('#formEditData')[0].reset();
            $('#ebiodata_id').val(res.biodataId),
                $('#eid').val(res.id),
                $('#eschoolName').val(res.schoolName),
                $('#ecity').val(res.city),
                $('#ecountry').val(res.country),
                $('#eentryYear').val(res.entryYear),
                $('#egraduationYear').val(res.graduationYear),
                $('#emajor').val(res.major),
                $('#egpa').val(res.gpa),
                // $('#ejudulTa').val(res.judulTa),
                // $('#edeskripsiTa').val(res.deskripsiTa),
                $('#enotes').val(res.notes),
                showTAorSkripsi(res.educationLevelId),
                $.ajax({
                    url: 'api/education-level',
                    type: 'get',
                    contentType: "application/json",
                    success: function (result) {
                        var optValue = "";
                        optValue += '<option value="">- Pilih -</option>';
                        for (var i = 0; i < result.length; i++) {
                            if (res.educationLevelId == result[i].id) {
                                optValue += `<option value="${result[i].id}" selected="selected">${result[i].name}</option>`;
                            } else {
                                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
                            }
                        }
                        $("#eeducationLevelId").html(optValue);

                    },
                    error: function () {
                        swal.fire("Error!", "Fetch Education Detail Failed", "error");
                    }
                })
        },
        error: () => {
            swal.fire("Error!", "Fetch Data Failed", "error");
        }
    })
}

$('#editBtn').click(() => {
    if ($('#eschoolName').val() == "" && $("#eeducationLevelId").val() == "") {
        swal.fire("Data empty!", "Data Nama Sekolah/Instansi, Jenjang Pendidikan Masih Kosong", "error");
    } else if ($('#eschoolName').val() == "") {
        swal.fire("Data empty!", "Data Sekolah Masih Kosong", "error");
    } else if ($("#eeducationLevelId").val() == "") {
        swal.fire("Data empty!", "Data Level Education Masih Kosong", "error");
    } else {
        if ($('#egraduationYear').val() < $('#eentryYear').val()) {
            swal.fire("Graduation Year > Entry Year", "Make Sure Data Graduation Year & Entry Year ", "error");
        } else {
            var id = $('#eid').val();
            var biodata_id = $('#ebiodata_id').val();
            var data = getFormData($('#formEditData'));
            $.ajax({
                url: 'api/education/' + id,
                type: 'put',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: (res) => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Update Data Success',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    $('#editData').modal('hide');
                    get_id_biodata(biodata_id);

                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-pendidikan-list').addClass("active");
                    $('#list-pendidikan').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
                error: () => {
                    swal.fire("Error!", "Update data error", "error");
                }
            })
        }
    }
})

$('#saveBtn').click(() => {
    if ($('#schoolName').val() == "" && $("#educationLevelId").val() == "") {
        swal.fire("Data empty!", "Data Nama Sekolah/Instansi, Jenjang Pendidikan Masih Kosong", "error");
    } else if ($('#schoolName').val() == "") {
        swal.fire("Data empty!", "Data Nama Sekolah/Instansi Masih Kosong", "error");
    } else if ($("#educationLevelId").val() == "") {
        swal.fire("Data empty!", "Data Jenjang Pendidikan Masih Kosong", "error");
    } else {
        var value_ipk = $('#gpa').val();
        var id = $('#biodataId').val();
        var data = getFormData($('#formAddData'));
        if (value_ipk > 4) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'IPK Max 4',
            })
        } else {
            $('#saveBtn').hasClass('disabled');

            $.ajax({
                url: 'api/education/',
                type: 'post',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: (res) => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Add Data Success',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    $('#addData').modal('hide');
                    get_id_biodata(id);


                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-pendidikan-list').addClass("active");
                    $('#list-pendidikan').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
                error: () => {
                    swal.fire("Error!", "Add data error", "error");
                }
            })
        }
    }
})

function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });
    return indexed_array;
}


// Eko
// get detail biodata
function detailData(id) {
    $.ajax({
        url: "/api/biodata-rest/" + id,
        type: "get",
        contentType: "application/json",
        success: function (result) {
            $("#get_form_biodata")[0].reset();
            get_marital(result.maritalStatus.id);
            get_religion(result.religion.id);
            get_identitas(result.identityType.id);
            $("#get_id").val(result.id);

            var gend = result.gender;
            var kelamin;
            if (gend == true) {
                kelamin = "Laki-laki";
            } else {
                kelamin = "Perempuan";
            }

            $("#biodata-rows").html(`
         <tr>
            <td>Nama Lengkap</td>
            <td>:    ${result.fullName}</td>
         </tr>
            <tr>
               <td>Nama Panggilan</td>
               <td>:    ${result.nickName}</td>
            </tr>
            <tr>
               <td>Kontak</td>
               <td>:   ${result.email} / ${result.phoneNumber1}</td>
            </tr>
            <tr>
               <td>Tempat, Tanggal Lahir</td>
               <td>:    ${result.pob}, ${result.dob}</td>
            </tr>
            <tr>
               <td>Jenis Kelamin, Tinggi(cm), Berat(Kg)</td>
               <td>:    ${kelamin}, ${result.hight},  ${result.weight}   </td>
            </tr>
            <tr>
               <td>Agama</td>
               <td>:    ${result.religion.name}</td>
            </tr>
            <tr>
               <td>Kewarganegaraan, Suku Bangsa</td>
               <td>:    ${result.nationality}, ${result.ethnic}</td>
            </tr>
            <tr>
               <td>Kegemaran / Hobi</td>
               <td>:    ${result.hobby}</td>
            </tr>
            <tr>
               <td>Jenis & Nomor Identitas</td>
               <td>:    ${result.identityType.name} - ${result.identityNo}</td>
            </tr>
            <tr>
               <td>Status & Tahun Pernikahan</td>
               <td>:    ${result.maritalStatus.name} - ${result.marriageYear}</td>
            </tr>

         `);

            $("#detailBiodata").modal("show");
        },

        error: function () {
            swal.fire("", "Failed to fetch the data", "error");
        }
    });
};

// get edit dengan modal full fitur 
function get_edit() {
    $("#detailBiodata").modal("hide");
    var id = $("#get_id").val();
    get_data_byid(id, 'edit');
}


function get_data_byid(id, action) {
    $("#action").val(action);
    if (action == "detail") {
        $(".modal-judul").text("Detail Pelamar ");
        $("#sava_button").attr("disabled", true);
        $(".x-hide").hide();
    } else {
        $(".modal-judul").text("Edit Biodata");
        $(".get_biodata").attr("disabled", false);
        $(".x-email").attr("disabled", true);
    }
    $.ajax({
        url: "/api/biodata-rest/" + id,
        type: "get",
        contentType: "application/json",
        success: function (result) {
            $("#get_form_biodata")[0].reset();

            get_marital(result.maritalStatus.id);
            get_religion(result.religion.id);
            get_identitas(result.identityType.id);

            $("#get_createdBy").val(result.createdBy);
            $("#get_createdOn").val(result.createdOn);

            $("#get_id").val(result.id);
            $("#get_companyid").val(result.companyId);
            $("#get_full_name").val(result.fullName);
            $("#get_nickname").val(result.nickName);
            $("#get_pob").val(result.pob);
            $("#get_dob").val(result.dob);

            var optValue = "";
            optValue += '<option value="">- Pilih -</option>';
            if (result.gender == true) {
                optValue += `<option value="true" selected="selected">Laki-laki</option>`;
                optValue += `<option value="false">Perempuan</option>`;
            } else {
                optValue += `<option value="true">Laki-laki</option>`;
                optValue += `<option value="false" selected="selected">Perempuan</option>`;
            }
            $("#get_gender").html(optValue);

            $("#get_hight").val(result.hight);
            $("#get_weight").val(result.weight);
            $("#get_nationality").val(result.nationality);
            $("#get_ethnic").val(result.ethnic);
            $("#get_hobby").val(result.hobby);
            $("#get_email").val(result.email);
            $("#get_no_hp1").val(result.phoneNumber1);
            $("#get_no_hp2").val(result.phoneNumber2);
            $("#get_parent_telphone").val(result.parentPhoneNumber);
            $("#get_child_secuence").val(result.childSequence);
            $("#get_how_many_brother").val(result.howManyBrothers);
            $("#get_marriage_year").val(result.marriageYear);
            $("#get_no_indentity").val(result.identityNo);

            $.ajax({
                url: "/api/address/bio/" + result.id,
                type: "get",
                contentType: "application/json",
                success: function (res) {
                    let add = res[0];

                    $("#get_addressid").val(add.id);
                    $("#get_address1").val(add.address1);
                    $("#get_address2").val(add.address2);
                    $("#get_postal_code1").val(add.postalCode1);
                    $("#get_postal_code2").val(add.postalCode2);
                    $("#get_rt1").val(add.rt1);
                    $("#get_rt2").val(add.rt2);
                    $("#get_rw1").val(add.rw1);
                    $("#get_rw2").val(add.rw2);
                    $("#get_kelurahan1").val(add.kelurahan1);
                    $("#get_kelurahan2").val(add.kelurahan2);
                    $("#get_kecamatan1").val(add.kecamatan1);
                    $("#get_kecamatan2").val(add.kecamatan2);
                    $("#get_region1").val(add.region1);
                    $("#get_region2").val(add.region2);
                },
                error: function () {
                    swal.fire("", "Failed Load address", "error");
                }
            });
            $("#modal-biodata").modal("show");
        },

        error: function () {
            swal.fire("", "Failed to fetch the data", "error");
        }
    });
};

function get_religion(relId) {
    $.ajax({
        url: "../api/religion",
        type: "get",
        contentType: "application/json",
        success: function (rel) {
            var optValue = "";
            optValue += '<option value="">- Pilih Agama -</option>';
            for (var i = 0; i < rel.length; i++) {
                if (relId == rel[i].id) {
                    optValue += `<option value="${rel[i].id}" selected="selected">${rel[i].name}</option>`;
                } else {
                    optValue += `<option value="${rel[i].id}">${rel[i].name}</option>`;
                }
            }
            $("#get_religion").html(optValue);
        },
        error: function () {
            swal("", "Gagal Mengambil Data", "error");
        }
    });
};

function get_marital(marId) {
    $.ajax({
        url: "../api/marital",
        type: "get",
        contentType: "application/json",
        success: function (mar) {
            var optValue = "";
            optValue += '<option value="">- Pilih Status -</option>';
            for (var i = 0; i < mar.length; i++) {
                if (marId == mar[i].id) {
                    optValue += `<option value="${mar[i].id}" selected="selected">${mar[i].name}</option>`;
                } else {
                    optValue += `<option value="${mar[i].id}">${mar[i].name}</option>`;
                }
            }
            $("#get_marital_status").html(optValue);
        },
        error: function () {
            swal("", "Gagal Mengambil Data", "error");
        }
    });
};

function get_identitas(identId) {
    $.ajax({
        url: "../api/identitas",
        type: "get",
        contentType: "application/json",
        success: function (ident) {
            var optValue = "";
            optValue += '<option value="">- Pilih Identitas -</option>';
            for (var i = 0; i < ident.length; i++) {
                if (identId == ident[i].id) {
                    optValue += `<option value="${ident[i].id}" selected="selected">${ident[i].name}</option>`;
                } else {
                    optValue += `<option value="${ident[i].id}">${ident[i].name}</option>`;
                }
            }
            $("#get_type_identity").html(optValue);
        },
        error: function () {
            swal("", "Gagal Mengambil Data", "error");
        }
    });
};

function get_marriage_year() {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih Tahun Nikah -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#get_marriage_year").html(value_year);
};

$("#save_button").click(function () {
    var action = $("#action").val();

    var data = {
        id: $("#get_id").val(),
        fullName: $("#get_full_name").val(),
        nickName: $("#get_nickname").val(),
        pob: $("#get_pob").val(),
        dob: $("#get_dob").val(),
        gender: $("#get_gender").val(),
        hight: $("#get_hight").val(),
        weight: $("#get_weight").val(),
        nationality: $("#get_nationality").val(),
        ethnic: $("#get_ethnic").val(),
        hobby: $("#get_hobby").val(),
        email: $("#get_email").val(),
        phoneNumber1: $("#get_no_hp1").val(),
        phoneNumber2: $("#get_no_hp2").val(),
        parentPhoneNumber: $("#get_parent_telphone").val(),
        childSequence: $("#get_child_secuence").val(),
        howManyBrothers: $("#get_how_many_brother").val(),
        marriageYear: $("#get_marriage_year").val(),
        identityNo: $("#get_no_indentity").val(),
        companyId: $("#get_companyid").val(),
        createdBy: parseInt($("#get_createdBy").val()),
        createdOn: $("#get_createdOn").val(),
        religion: {
            id: $("#get_religion").val()
        },
        maritalStatus: {
            id: $("#get_marital_status").val()
        },
        identityType: {
            id: $("#get_type_identity").val()
        },

        biodataId: {
            id: $("#get_id").val()
        },
        idA: $("#get_addressid").val(),
        address1: $("#get_address1").val(),
        address2: $("#get_address2").val(),
        rt1: $("#get_rt1").val(),
        rt2: $("#get_rt2").val(),
        rw1: $("#get_rw1").val(),
        rw2: $("#get_rw2").val(),
        kelurahan1: $("#get_kelurahan1").val(),
        kelurahan2: $("#get_kelurahan2").val(),
        kecamatan1: $("#get_kecamatan1").val(),
        kecamatan2: $("#get_kecamatan2").val(),
        region1: $("#get_region1").val(),
        region2: $("#get_region2").val(),
        postalCode1: $("#get_postal_code1").val(),
        postalCode2: $("#get_postal_code2").val()
    };

    //Mengambil nilai inputan
    var fullName = $("#get_full_name").val();
    var nickName = $("#get_nickname").val();
    var pob = $("#get_pob").val();
    var dob = $("#get_dob").val();
    var gender = $("#get_gender").val();
    var email = $("#get_email").val();
    var phoneNumber1 = $("#get_no_hp1").val();
    var phoneNumber1 = $("#get_no_hp1").val();
    var parentPhoneNumber = $("#get_parent_telphone").val();
    var childSequence = $("#get_child_secuence").val();
    var howManyBrothers = $("#get_how_many_brother").val();
    var religion = $("#get_religion").val();
    var maritalStatus = $("#get_marital_status").val();
    var identityType = $("#get_type_identity").val();
    var identityNo = $("#get_no_indentity").val();
    var hight = $("#get_hight").val();
    var weight = $("#get_weight").val();
    var nationality = $("#get_nationality").val();
    var address1 = $("#get_address1").val();
    var address2 = $("#get_address2").val();
    var rt1 = $("#get_rt1").val();
    var rt2 = $("#get_rt2").val();
    var rw1 = $("#get_rw1").val();
    var rw2 = $("#get_rw2").val();
    var kelurahan1 = $("#get_kelurahan1").val();
    var kelurahan2 = $("#get_kelurahan2").val();
    var kecamatan1 = $("#get_kecamatan1").val();
    var kecamatan2 = $("#get_kecamatan2").val();
    var region1 = $("#get_region1").val();
    var region2 = $("#get_region2").val();
    // ending inputan

    if (action == "add") {
        type = "post";
    } else if (action == "edit") {
        type = "put";
    }

    if (fullName == "" || null) {
        swal.fire("Required", "Mohon isi nama lengkap anda", "info");
    } else if (nickName == "" || null) {
        swal.fire("Required", "Mohon isi nama Panggilan anda", "info");
    } else if (pob == "" || null) {
        swal.fire("Required", "Mohon isi nama Tempat Lahir anda", "info");
    } else if (dob == "" || null) {
        swal.fire("Penting", "Mohon isi nama Tanggal Lahir anda", "question");
    } else if (gender == "" || null) {
        swal.fire("Penting", "Anda belum memilih jenis kelamin.", "question");
    } else if (religion == "" || null) {
        swal.fire("Penting", "Anda belum memilih Agama.", "question");
    } else if (hight == "" || null) {
        swal.fire("Required", "Anda belum mengisi field Tinggi badan.", "question");
    } else if (weight == "" || null) {
        swal.fire("Required", "Anda belum mengisi field berat badan.", "question");
    } else if (nationality == "" || null) {
        swal.fire("Required", "Anda belum mengisi Kewarganegaraan Anda.", "question");
    } else if (identityType == "" || null) {
        swal.fire("Penting", "Anda belum memilih tipe identitas.", "question");
    } else if (email == "" || null) {
        swal.fire("Required", "Pastikan email telah diisi.", "info");
    } else if (phoneNumber1 == "" || null) {
        swal.fire("Required", "Pastikan nomor HP kamu telah diisi.", "info");
    } else if (parentPhoneNumber == "" || null) {
        swal.fire("Required", "Pastikan nomor HP Orang tua telah diisi.", "info");
    } else if (childSequence > howManyBrothers) {
        swal.fire("Penting", "Urutan kelahiran tidak boleh lebih dari jumlah saudara", "info");
    } else if (childSequence == "" || null) {
        swal.fire("Required", "Field anak ke belum diisi.", "info");
    } else if (howManyBrothers == "" || null) {
        swal.fire("Required", "Banyak saudara anda belum diisi.", "info");
    } else if (maritalStatus == "" || null) {
        swal.fire("Penting", "Status pernikahanmu?", "question");
    } else if (validateEmail(email) == false) {
        swal.fire("Fatal", "Email yang anda masukkan tidak valid", "warning");
    } else if (address1 == "" || null) {
        swal.fire("Required", "Anda belum mengisi alamat asal.", "question");
    } else if (address2 == "" || null) {
        swal.fire("Required", "Anda belum mengisi alamat Domisili.", "question");
    } else if (rt1 == "" || null) {
        swal.fire("Required", "Anda belum mengisi Nomor Rt.", "question");
    } else if (rt2 == "" || null) {
        swal.fire("Required", "Anda belum mengisi Nomor Rt domisili.", "question");
    } else if (rw1 == "" || null) {
        swal.fire("Required", "Anda belum mengisi Nomor rw.", "question");
    } else if (rw2 == "" || null) {
        swal.fire("Required", "Anda belum mengisi Nomor rw domisili.", "question");
    } else if (kelurahan1 == "" || null) {
        swal.fire("Required", "Anda belum mengisi kelurahan.", "question");
    } else if (kelurahan2 == "" || null) {
        swal.fire("Required", "Anda belum mengisi kelurahan Domisili.", "question");
    } else if (kecamatan1 == "" || null) {
        swal.fire("Required", "Anda belum mengisi kecamatan.", "question");
    } else if (kecamatan2 == "" || null) {
        swal.fire("Required", "Anda belum mengisi kecamatan Domisili.", "question");
    } else if (region1 == "" || null) {
        swal.fire("Required", "Anda belum mengisi kecamatan.", "question");
    } else if (region2 == "" || null) {
        swal.fire("Required", "Anda belum mengisi kecamatan Domisili.", "question");
    } else {

        // cek email-no identitas-no hp
        $.ajax({
            url: "/api/biodata-rest/",
            type: "get",
            contentType: "application/json",
            success: function (cek) {
                if (cek.length > 0) {
                    var cek_eml = false;
                    var cek_no_idn = false;
                    var cek_no_hp = false;

                    for (let i = 0; i < cek.length; i++) {
                        if (email == cek[i].email) {
                            cek_eml = true;
                        }
                        if (identityNo == cek[i].identityNo && identityType == cek[i].identityType.id) {
                            cek_no_idn = true;
                        }
                        if (phoneNumber1 == cek[i].phoneNumber1) {
                            cek_no_hp = true;
                        }
                    }

                    if (type == 'put') {
                        // save
                        $.ajax({
                            url: "/api/biodata-rest",
                            type: type,
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            success: function (result) {
                                $("#get_form_biodata")[0].reset();
                                detailData($("#get_id").val());
                                Swal.fire({
                                    icon: 'success',
                                    title: action + ' Data Success',
                                    showConfirmButton: false,
                                    timer: 1500
                                })
                                $("#modal-biodata").modal("hide");
                            },
                            error: function () {
                                Swal.fire("", "Failed to " + action + " data", "error");
                            }
                        });
                    } else {

                        if (cek_eml == true) {
                            swal.fire("Forbidden", "Email telah digunakan.", "warning");
                        } else if (cek_no_idn == true) {
                            swal.fire("Forbidden", "Nomor Identitas tidak boleh sama.", "warning");
                        } else if (cek_no_hp == true) {
                            swal.fire("Forbidden", "Nomor HP anda tidak boleh sama.", "warning");
                        } else {

                            //save
                            $.ajax({
                                url: "/api/biodata-rest",
                                type: type,
                                contentType: "application/json",
                                data: JSON.stringify(data),
                                success: function (result) {
                                    $("#get_form_biodata")[0].reset();
                                    detailData($("#get_id").val());
                                    Swal.fire({
                                        icon: 'success',
                                        title: action + ' Data Success',
                                        showConfirmButton: false,
                                        timer: 1500
                                    })
                                    $("#modal-biodata").modal("hide");
                                },
                                error: function () {
                                    Swal.fire("", "Failed to " + action + " data", "error");
                                }
                            });
                        };
                    }
                };
            }
        });
    };
});

// validasi inputan email 
function validateEmail(em) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(em);
}
// Eko

$(function () {
    $('#get_dob').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true,
        opens: 'left',
        minYear: 1980,
        maxYear: parseInt(moment().format('YYYY'), 10),
        locale: {
            format: 'YYYY-MM-DD'
        }
    });
});

$("#add_button").click(function () {
    get_marital();
    get_religion();
    get_identitas();
    $(".modal-judul").text("Tambah Pelamar");
    $(".get_biodata").attr("disabled", false);
    $("#get_form_biodata")[0].reset();
    $("#get_id").val("");

    var optValue = "";
    optValue += '<option value="">- Pilih -</option>';
    optValue += `<option value="true">Laki-laki</option>`;
    optValue += `<option value="false">Perempuan</option>`;

    $("#get_gender").html(optValue);
    $("#action").val("add");
    $("#modal-biodata").modal("show");
});

$('#get_marital_status').change(function () {
    var x = $('#get_marital_status').val()
    if (x == 1) {
        $('.year_marriage').attr('disabled', true);
    } else {
        $('.year_marriage').attr('disabled', false);
    }
})


// Pelatihan
$('#showaddDataPelatihan').click(() => {
    $('#addDataPelatihan').modal('show');
    $('#detailVacancy').modal('hide');
})

$(() => {
    get_training_year();
});
get_training_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih Tahun -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#trainingYear").html(value_year);
}

$(() => {
    eget_training_year();
});
eget_training_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#etrainingYear").html(value_year);
}



$(() => {
    get_time_period();
});
get_time_period = () => {
    $.ajax({
        url: 'api/time',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">- Pilih -</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
            }
            $("#timePeriodId").html(optValue);

        },
        error: function () {
            swal("", "Gagal Mengambil Data", "error");
        }
    })
}

function get_id_pelatihan_delete(vacancyId, trainingName, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
        title: 'Hapus Pelatihan ?',
        text: "Anda yakin ingin menghapus pelatihan " + trainingName + " ?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/pelatihan/' + vacancyId,
                type: 'delete',
                contentType: 'application/json',
                success: () => {

                    swalWithBootstrapButtons.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                    get_id_biodata(id);

                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-pelatihan-list').addClass("active");
                    $('#list-pelatihan').addClass("show active");

                    $('#detailVacancy').modal('show');


                },
            })
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your imaginary file is safe :)',
                'error'
            )
            get_id_biodata(id);

            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-pelatihan-list').addClass("active");
            $('#list-pelatihan').addClass("show active");

            $('#detailVacancy').modal('show');
        }
    })
}


function get_id_pelatihan_edit(vacancyId) {
    $('#detailVacancy').modal('hide');
    $.ajax({
        url: 'api/pelatihan/' + vacancyId,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {
            $('#formeditDataPelatihan')[0].reset();
            $('#eidPelatihan').val(res.id),
                $('#etrainingName').val(res.trainingName),
                $('#eCreatedOn').val(res.createdOn),
                $('#eCreatedBy').val(res.createdBy),
                $('#eBiodataId').val(res.biodataId),
                $('#eorganizer').val(res.organizer),
                $('#etrainingMonth').val(res.trainingMonth),
                $('#etrainingYear').val(res.trainingYear),
                $('#etrainingDuration').val(res.trainingDuration),
                $('#ecity').val(res.city),
                $('#ecountry').val(res.country),
                $('#enotes').val(res.notes),
                $.ajax({
                    url: 'api/time',
                    type: 'get',
                    contentType: "application/json",
                    success: function (result) {
                        var optValue = "";
                        optValue += '<option value="">- Pilih -</option>';
                        for (var i = 0; i < result.length; i++) {
                            if (res.timePeriodId == result[i].id) {
                                optValue += `<option value="${result[i].id}" selected="selected">${result[i].name}</option>`;
                            } else {
                                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
                            }
                        }
                        $("#etimePeriodId").html(optValue);

                    },
                    error: function () {
                        swal("", "Gagal Mengambil Data", "error");
                    }
                })
        },
        error: () => {
            swal.fire("Error!", "Fetch Data Pelatihan", "error");
        }
    })
}

$('#editBtnPelatihan').click(() => {
    var data = getFormData($('#formeditDataPelatihan'));
    var id = $('#eidPelatihan').val();
    if ($('#etrainingName').val() == "") {
        swal.fire("Data Nama Pelatihan Tidak Boleh Kosong", "", "error");
    }
    else if ($('#eorganizer').val() == "") {
        swal.fire("Data Penyelenggara Tidak Boleh Kosong", "", "error");
    } else {
        $.ajax({
            url: 'api/pelatihan/' + id,
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                $('#editDataPelatihan').modal('hide');
                swal.fire("Data Berhasil Diubah ", "", "success");
                get_id_biodata($("#eBiodataId").val());
                $('#detailVacancy').modal('show');
            },
            error: () => {
                swal.fire("Data Gagal Di Ubah", "", "error")
                loadData();
            }
        })
    }
})

$('#closeBtnBawah').click(() => {
    $('#formaddDataPelatihan')[0].reset();
})

$('#closeBtn').click(() => {
    $('#formaddDataPelatihan')[0].reset();
})


$('#saveBtnPelatihan').click(() => {
    var data = getFormData($('#formaddDataPelatihan'));
    var biodataId = $('#biodataId').val();
    if ($('#trainingName').val() == "") {
        swal.fire("Data Nama Pelatihan Tidak Boleh Kosong", "", "error");
    }
    else if ($('#organizer').val() == "") {
        swal.fire("Data Penyelenggara Tidak Boleh Kosong", "", "error");
    } else {
        $.ajax({
            url: 'api/pelatihan/',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                $('#addDataPelatihan').modal('hide');
                swal.fire("Data Berhasil Disimpan ", "", "success");
                get_id_biodata(biodataId);
                $('#detailVacancy').modal('show');
                $('#formaddDataPelatihan')[0].reset();
            },
            error: () => {
                swal.fire("Data Gagal Disimpan", "", "error");
                $('#detailVacancy').modal('show');
            }
        })
    }
})

$('#addDataPelatihan').on('hidden.bs.modal', function () {


    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-pelatihan-list').addClass("active");
    $('#list-pelatihan').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#editDataPelatihan').on('hidden.bs.modal', function () {


    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-pelatihan-list').addClass("active");
    $('#list-pelatihan').addClass("show active");

    $('#detailVacancy').modal('show');
});

// Pelatihan


// Organisasi, Document, & Activation Account
function get_type_test(id) {
    $('#idOnlineTest').val(id);
    $('#detailVacancy').modal('hide');
    var num = 1;
    $.ajax({
        url: 'api/onlineTest/' + id,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {
            if (res.status == "Selesai") {
                document.getElementById("tambahinTes").disabled = true;
                $.ajax({
                    url: 'api/onlineDetail/onlineTestDetail/' + id,
                    type: 'get',
                    contentType: 'application/json',
                    success: (res1) => {
                        $('#tbTambahTes').html("");
                        res1.map((data) => {
                            var markup = "<tr class='text-center'><td>" + num + "</td><td>" + data.name +
                                "</td><td></td>"
                            num++;
                            $('#tbTambahTes').append(markup);
                        })
                    },
                    error: () => {
                        swal.fire("Error!", "Fetch Data Test Type", "error");
                    }
                })
            } else {
                document.getElementById("tambahinTes").disabled = false;
                $.ajax({
                    url: 'api/onlineDetail/onlineTestDetail/' + id,
                    type: 'get',
                    contentType: 'application/json',
                    success: (res1) => {
                        $('#tbTambahTes').html("");
                        res1.map((data) => {
                            var act = '<a onclick="get_id_testType_delete(\'' + data.id + '\',\'' + data
                                .name + '\',\'' + id +
                                '\')"><i class="fa fa-trash" style="color:blue"aria-hidden="true"><i></a>'
                            var markup = "<tr class='text-center'><td>" + num + "</td><td>" + data.name +
                                "</td><td>" + act + "</td></tr>"
                            num++;
                            $('#tbTambahTes').append(markup);
                        })
                    },
                    error: () => {
                        swal.fire("Error!", "Fetch Data Detail Test Type", "error");
                    }
                })

            }


            $.ajax({
                url: "api/onlineDetail/lastOrder?onlineTestId=" + id,
                type: "get",
                contentType: "application/json",
                success: function (res) {
                    res.map((data) => {
                        var order = data.testOrder + 1;
                        $('#lastOrder').val(order);
                    })
                },
                error: function () {
                    swal.fire("Error!", "Fetch Data Last Order", "error");
                }
            })
        },
        error: () => {
            swal.fire("Error!", "Fetch Data Online Test", "error");
        }
    })
}

$(function () {
    $("#timepick").daterangepicker({
        autoUpdateInput: true,
        singleDatePicker: true,
        showDropdowns: true,
        minDate: new Date(),
        locale: {
            format: "YYYY-MM-DD"
        }
    });
});



$("#timepick").on("change", function () {
    var mindts = $("#timepick").val();
    setmindate_kapan2(mindts);
});

function setmindate_kapan2(min) {
    $("#timepicker").daterangepicker({
        autoUpdateInput: true,
        singleDatePicker: true,
        showDropdowns: true,
        minDate: min,
        locale: {
            format: "YYYY-MM-DD"
        }
    });
}

$('#tambahOrg').click(() => {
    $('#detailVacancy').modal('hide');
    $('#formAddOrg input[type=text]').val("");
    $('#formAddOrg textarea[type=text]').val("");
    var temp = "";
    $('#entryYear').val(temp);
    $('#exitYear').val(temp);
})

function click_aktifasi() {
    var idbio = $('#biodId').val();
    $('#aktifasiAkun input[type=text]').val("");
    $('#periodeCode').val("");
    $('#period').val("");
    $('#akses').val("");
    var uname = $('#uname').val();
    var pass = $('#pass').val();
    if (uname == "" && pass == "") {
        $('#abuid').val(generator(2));
        $('#abpwd').val($('#abuid').val());
    } else {
        $('#abuid').val("");
        $('#abpwd').val("");
    }
    list_show = [];
    list_dele = [];
    list_idto = [];
    var j = document.getElementById("aktifasi");
    if (j.innerHTML == "Aktifkan") {
        $('#detailVacancy').modal("hide");
        $('#detailTest').html("");
        $('#aktif').modal("show");
        $.ajax({
            url: 'api/onlineTest/lastPeriod?biodataId=' + idbio,
            type: 'get',
            contentType: 'application/json',
            success: function (result) {
                if (result.length > 0) {
                    result.map((res) => {
                        var periodtemp = res.period + 1;
                        $('#period').val(periodtemp);
                    })
                } else {
                    var tempperiod = 1;
                    $('#period').val(tempperiod);
                }
            },
            error: function () {
                swal.fire("Error!", "Fetch Data Period", "error");
            }
        })

        $.ajax({
            url: 'api/onlineTest/lastCodePeriod?biodataId=' + idbio,
            type: 'get',
            contentType: 'application/json',
            success: function (hasil) {
                if (hasil.length > 0) {
                    hasil.map((hsl) => {
                        var code = hsl.periodeCode
                        var res = code.substring(3, code.length);
                        var cd = parseInt(res) + 1;
                        var str = cd.toString().padStart(4, "0")
                        var codeperiod = "PRD" + str;
                        $('#periodeCode').val(codeperiod);
                    })
                } else {
                    var code = 1;
                    var str = code.toString().padStart(4, "0")
                    var codeperiod = "PRD" + str;
                    $('#periodeCode').val(codeperiod);
                }
            }
        })

    } else {
        $.ajax({
            url: 'api/onlineTest/ubahStatus?biodataId=' + idbio,
            type: 'delete',
            contentType: 'application/json',
            success: () => {
                swal.fire("", "Akun Berhasil Di Non-Aktifkan!", "success");
                j.innerHTML = "Aktifkan"
                get_id_biodata(idbio);
            }
        })
    }
}

$('#aktif').on('show.bs.modal', function () {
    $('#detailTest').html("");
    showList();
})

$('#tambahinTes').click(() => {
    $('#EditTest').modal('hide');
    $('#addTest').modal('show');
    $('#pilihTestType').val("");
})

$('#nambahTest').click(() => {
    $('#pilihTest').val("");
})

$('#tambahDoc').click(() => {
    $('#detailVacancy').modal('hide');
    $('#formAddDoc input[type=text]').val("");
    $('#formAddDoc input[type=file]').val("");
})

$(document).ready(function () {
    document.getElementById("photoPreview").src = "../../images/field.png";
})

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#photoPreview').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

// view nama file
var uploadField = document.getElementById("file");
uploadField.onchange = function () {
    var nama = document.getElementById('file').value;
    var ext = nama.slice(nama.length - 4, nama.length);
    var dt = new Date();
    var nametemp = `${
        dt.getFullYear().toString().padStart(4, '0')}${
        (dt.getMonth() + 1).toString().padStart(2, '0')}${
        dt.getDate().toString().padStart(2, '0')}${
        dt.getHours().toString().padStart(2, '0')}${
        dt.getMinutes().toString().padStart(2, '0')}${
        dt.getSeconds().toString().padStart(2, '0')}`;
    var pathName = "attachments/" + nametemp + ext;
    $('#filePath').val(pathName);
    if (this.files[0].size > (500 * 1024)) {
        swal.fire("File Size!", "Ukuran File Terlalu Besar Max 500KB", "error")
        this.value = "";
    }
    else {
        var temp = nama.slice(12, nama.length - 4);
        document.getElementsByName('fileName')[0].value = temp;
    }
};

// preview photo
var uploadFotoField = document.getElementById("unggahFoto");
uploadFotoField.onchange = function () {
    var viewName = "";
    var index, temp = "";
    var namaFoto = document.getElementById('unggahFoto').value;
    for (index = 0; index < namaFoto.length; index++) {
        if (namaFoto.charAt(index) == '.') {
            temp += namaFoto.slice(index, namaFoto.length);
            viewName += namaFoto.slice(12, index);
            document.getElementsByName('fileName')[0].value = viewName;
        }
    }
    var dt = new Date();
    var nametemp = `${
        dt.getFullYear().toString().padStart(4, '0')}${
        (dt.getMonth() + 1).toString().padStart(2, '0')}${
        dt.getDate().toString().padStart(2, '0')}${
        dt.getHours().toString().padStart(2, '0')}${
        dt.getMinutes().toString().padStart(2, '0')}${
        dt.getSeconds().toString().padStart(2, '0')}`;
    $('#filePath').val("attachments/" + nametemp + temp);
    if (temp == ".jpg" || temp == ".jpeg" || temp == ".png" || temp == ".gif") {
        if (this.files[0].size > (500 * 1024)) {
            swal.fire("File Size!", "Ukuran Foto Terlalu Besar Max 500KB", "error")
            this.value = "";
        } else {
            readURL(this);
        }
    } else {
        swal.fire("File Type!!", "Type File Hanya Khusus JPG/JPEG/PNG/GIF", "error")
    }
};

function EreadURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#ephotoPreview').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

// view nama file
var uploadFileField = document.getElementById("efile");
uploadFileField.onchange = function () {
    $('#efileName').val("");
    var nama = document.getElementById('efile').value;
    var ext = nama.slice(nama.length - 4, nama.length);
    var dt = new Date();
    var nametemp = `${
        dt.getFullYear().toString().padStart(4, '0')}${
        (dt.getMonth() + 1).toString().padStart(2, '0')}${
        dt.getDate().toString().padStart(2, '0')}${
        dt.getHours().toString().padStart(2, '0')}${
        dt.getMinutes().toString().padStart(2, '0')}${
        dt.getSeconds().toString().padStart(2, '0')}`;
    var pathName = "attachments/" + nametemp + ext;
    $('#efilePath').val(pathName);
    if (this.files[0].size > (500 * 1024)) {
        swal.fire("File Size!", "Ukuran File Terlalu Besar Max 500KB", "error")
        this.value = "";
    } else {
        var temp = nama.slice(12, nama.length - 4);
        $('#efileName').val(temp);
    }
};

// preview photo
var uploadFileFotoField = document.getElementById("eunggahFoto");
uploadFileFotoField.onchange = function () {
    var viewName = "";
    var index, temp = "";
    $('#efileName').val("");
    var namaFoto = document.getElementById('eunggahFoto').value;
    for (index = 0; index < namaFoto.length; index++) {
        if (namaFoto.charAt(index) == '.') {
            temp += namaFoto.slice(index, namaFoto.length);
            viewName += namaFoto.slice(12, index);
            $('#efileName').val(viewName);
        }
    }
    var dt = new Date();
    var nametemp = `${
        dt.getFullYear().toString().padStart(4, '0')}${
        (dt.getMonth() + 1).toString().padStart(2, '0')}${
        dt.getDate().toString().padStart(2, '0')}${
        dt.getHours().toString().padStart(2, '0')}${
        dt.getMinutes().toString().padStart(2, '0')}${
        dt.getSeconds().toString().padStart(2, '0')}`;
    $('#efilePath').val("attachments/" + nametemp + temp);
    if (temp == ".jpg" || temp == ".jpeg" || temp == ".png" || temp == ".gif") {
        if (this.files[0].size > (500 * 1024)) {
            swal.fire("File Size!", "Ukuran Foto Terlalu Besar Max 500KB", "error")
            this.value = "";
        } else {
            EreadURL(this);
        }
    } else {
        swal.fire("File Type!!", "Type File Hanya Khusus JPG/JPEG/PNG/GIF", "error")
    }
};

$('#edSaveAva').click(() => {
    var data = getFormData($('#formAddDoc'));
    var idDoc = $('#edid').val();
    var id = $('#bioId').val();
    if ($('#fileName').val() == "") {
        swal.fire("Data Kosong!!", "Data Nama File Tidak Boleh Kosong", "error")
    } else {
        $.ajax({
            url: '/api/dokumen/' + idDoc,
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                $('#AddDoc').modal('hide');
                get_id_biodata(id);
                swal.fire("Data Berhasil Disimpan", "", "success");
                $('#detailVacancy').modal('show');
            }
        })
    }
})

function getPath() {
    var nama = document.getElementById('file').value;
}

function saving() {
    var data = getFormData($('#formAddDoc'));
    var id = $('#bioId').val();
    if ($('#fileName').val() == "") {
        swal.fire("Data Kosong!!", "Data Nama File Tidak Boleh Kosong", "error")
    } else {
        $.ajax({
            url: '/api/dokumen/',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                $('#AddDoc').modal('hide');
                get_id_biodata(id);
                swal.fire("Data Berhasil Disimpan", "", "success");
                $('#detailVacancy').modal('show');
            },
            error: () => {
                $('#AddDoc').modal('hide');
                swal.fire("Data Gagal Disimpan", "", "error")
                $('#detailVacancy').modal('show');
            }
        })
    }
};

function saveAvatar() {
    var data = getFormData($('#formAddDoc'));
    var id = $('#bioId').val();
    if ($('#fileName').val() == "") {
        swal.fire("Data Kosong!!", "Data Nama File Tidak Boleh Kosong", "error")
    } else {
        $.ajax({
            url: '/api/dokumen/uploadFoto',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                $('#AddDoc').modal('hide');
                get_id_biodata(id);
                swal.fire("Data Berhasil Disimpan", "", "success");
                $('#detailVacancy').modal('show');
            },
            error: () => {
                $('#AddDoc').modal('hide');
                swal.fire("Data Gagal Disimpan", "", "error")
                $('#detailVacancy').modal('show');
            }
        })
    }
};

$('#updateDoc').click(() => {
    var data = getFormData($('#formEditDoc'));
    var ebioid = $('#ebioId').val();
    var eid = $('#edid').val();
    if ($('#efileName').val() == "") {
        swal.fire("Data Kosong!!", "Data Nama Tidak Boleh Kosong", "error");
    } else {
        $.ajax({
            url: 'api/dokumen/' + eid,
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                $('#editDataDoc').modal('hide');
                get_id_biodata(ebioid);
                swal.fire("Data Berhasil Diupdate", "", "success");
                $('#detailVacancy').modal('show');
            },
            error: () => {
                swal.fire("Data Gagal Disimpan", "", "error")
            }
        })
    }

});


$('#saveBtnOrganisasi').click(() => {
    var data = getFormData($('#formAddOrg'));
    var id = $('#biodataIdOrganisasi').val();
    if ($('#name').val() == "") {
        swal.fire("ERROR", "Data Nama Organisasi Kosong!!", "error")
    } else if ($('#position').val() == "") {
        swal.fire("ERROR", "Data Jabatan Kosong!!", "error")
    } else if ($('#entryYearOrganisasi').val() == "") {
        swal.fire("ERROR", "Data Tahun Masuk Kosong!!", "error")
    } else if ($('#exitYearOrganisasi').val() == "") {
        swal.fire("ERROR", "Data Tahun Keluar Kosong!!", "error")
    } else {
        $.ajax({
            url: '/api/organisasi/',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                $('#AddOrg').modal('hide');
                get_id_biodata(id);
                swal.fire("Data Berhasil Disimpan", "", "success");
                $('#detailVacancy').modal('show');
            },
            error: () => {
                swal.fire("Data Gagal Disimpan", "", "error")
            }
        })
    }
})

$('#editBtnOrganisasi').click(() => {
    var data = getFormData($('#formEditOrg'));
    var bioid = $('#biodataIdOrganisasi').val();
    var id = $('#eidor').val();
    if ($('#edentryYear').val() <= $('#edexitYear').val()) {
        if ($("#edOrgName").val() == "") {
            swal.fire("ERROR", "Data Nama Kosong!!", "error")
        } else if ($('#edPosition').val() == "") {
            swal.fire("ERROR", "Data Jabatan Kosong!!", "error")
        } else if ($('#edentryYear').val() == "") {
            swal.fire("ERROR", "Data Tahun Masuk Kosong!!", "error")
        } else if ($('#edexitYear').val() == "") {
            swal.fire("ERROR", "Data Tahun Keluar Kosong!!", "error")
        } else {
            $.ajax({
                url: 'api/organisasi/' + id,
                type: 'put',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: (res) => {
                    $('#editDataOrg').modal('hide');
                    get_id_biodata(bioid);
                    swal.fire("Data Berhasil Disimpan", "", "success");
                    $('#detailVacancy').modal('show');
                },
                error: () => {
                    swal.fire("Data Gagal Disimpan", "", "error")
                }
            })
        }
    } else {
        swal.fire("Periksa Kembali", "Tahun Masuk Tidak Dapat Lebih Besar Dari Tahun Keluar", "error")
    }
})

$('#addEditTestType').click(() => {
    var data = getFormData($('#editJenisTest'));
    if ($('#pilihTestType').val() == "") {
        swal.fire("Data Tidak Boleh Kosong", "Silahkan Pilih Jenis Tes Terlebih Dahulu", "error");
    } else {
        $.ajax({
            url: 'api/onlineDetail/post',
            type: 'post',
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (result) {
                swal.fire("BERHASIL!!", "Berhasil Menambahkan Jenis Tes", "success");
                get_type_test($('#idOnlineTest').val());
                $('#addTest').modal('hide');
                $('#EditTest').modal('show');
            },
            error: function () {
                swal.fire("Data Gagal Disimpan", "", "error")
            }
        })
    }
})

let list_show = [];
let list_dele = [];
let list_idto = [];

function showTestType() {
    if ($("#pilihTest").val() == "" || $("#pilihTest").val() == null) {
        swal.fire("Data Kosong!!", "Silahkan Pilih Jenis Tes Terlebih Dahulu", "error");
    } else {
        var show = $("#pilihTest option:selected").text();
        var idlist = $("#pilihTest").val();
        var del;
        del = '<a class="' + show + '" onclick="get_testType_delete(\'' + show + '\',\'' + idlist +
            '\')"><i class="fa fa-trash" style="color:blue"aria-hidden="true"><i></a>'
        list_show.push(show);
        list_dele.push(del);
        list_idto.push(idlist);
        $('#addJenisTest').modal('hide');
        $('#aktif').modal('show');
    }
}

function showList() {
    var i = 1;
    for (var index = 0; index < list_show.length; index++) {
        var all_list = '"<tr class="text-center"><td>' + i + '</td><td>' + list_show[index] +
            '</td><td style="display: none;">' + list_idto[index] + '</td><td>' + list_dele[index] + '</td></tr>';
        i++;
        $('#detailTest').append(all_list);
    }
}

function get_id_testType_delete(TestId, TestName, idTest) {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Test ?',
        text: "Anda yakin ingin menghapus " + TestName + " dari daftar tes ??",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/onlineDetail/' + TestId,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_type_test(idTest);
                    swalWithBootstrapButtons.fire('Deleted!', 'Your data has been deleted.', 'success')
                    $('#EditTest').modal('show');
                },
            })
        } else if (
            result.dismiss === Swal.DismissReason.cancel
        ) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your data file is safe :)',
                'error'
            )

            $('#detailVacancy').modal('show');
        }
    })
}

function get_testType_delete(TestName, TestId) {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Organisasi ?',
        text: "Anda yakin ingin menghapus " + TestName + "?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            for (var i = 0; i < list_show.length; i++) {
                if (list_show[i] === TestName && list_idto[i] === TestId) {
                    list_dele.splice(i, 1);
                    list_show.splice(i, 1);
                    list_idto.splice(i, 1);
                }
            }
            $('#detailTest').html("");
            $('#aktif').modal('show');
            showList();
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire('Cancelled', 'Your data file is safe :)', 'error')
        }
    })
}

function generator(length) {
    var result = '';
    var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var number = '0123456789'
    var charactersLength = characters.length;
    var numberLength = number.length;
    for (var i = 0; i < length; i++) {
        for (var j = 0; j < 2; j++) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        for (var j = 0; j < 2; j++) {
            result += number.charAt(Math.floor(Math.random() * numberLength));
        }
    }
    return result;
}

$('#kirim').click(() => {
    var data = getFormData($('#aktifasiAkun'));
    var dtadb = getFormData($('#addrBook'));
    if ($('#timepick').val() == "") {
        swal.fire("DATA TIDAK BOLEH KOSONG", "Tanggal Tes Tidak Boleh Kosong!", "error");
        $('#aktif').modal("show");
    } else if ($('#timepicker').val() == "") {
        swal.fire("DATA TIDAK BOLEH KOSONG", "Tanggal Berakhir Tes Tidak Boleh Kosong!", "error");
        $('#aktif').modal("show");
    } else if ($('#akses').val() == "") {
        swal.fire("DATA TIDAK BOLEH KOSONG", "Akses User Tidak Boleh Kosong!", "error");
        $('#aktif').modal("show");
    } else {
        if ($('#uname').val() == "" && $('#pass').val() == "") {
            $.ajax({
                url: 'api/addressBook',
                type: 'post',
                contentType: 'application/json',
                data: JSON.stringify(dtadb),
                success: function (rest) {
                    $.ajax({
                        url: 'api/addressBook/lastId',
                        type: 'get',
                        contentType: 'application/json',
                        success: function (rest1) {
                            rest1.map((rest11) => {
                                var dtid = {
                                    id: $('#biodId').val(),
                                    addrbookId: rest11.id
                                }
                                $.ajax({
                                    url: 'api/biodata/' + $('#biodId').val(),
                                    type: 'put',
                                    contentType: 'application/json',
                                    data: JSON.stringify(dtid),
                                    success: function (rest111) {
                                        get_id_biodata($('#biodId').val());
                                    }
                                })
                            })
                        }
                    })
                }
            })
        } else {
            swal.fire("", "Failed ! Username & Password Has Exist", "error");
        }
        $.ajax({
            url: 'api/onlineTest',
            type: 'post',
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (result) {
                $.ajax({
                    url: 'api/onlineTest/lastId',
                    type: 'get',
                    contentType: "application/json",
                    success: function (result) {
                        result.map((dat) => {
                            for (var i = 0; i < list_show.length; i++) {
                                var data = {
                                    onlineTestId: dat.id,
                                    testTypeId: list_idto[i],
                                    testOrder: i,
                                }
                                $.ajax({
                                    url: 'api/onlineDetail/post',
                                    type: 'post',
                                    contentType: "application/json",
                                    data: JSON.stringify(data),
                                    success: function (result) {
                                        swal.fire({
                                            title: 'Please Wait..!',
                                            text: 'Sending Email..',
                                            icon: 'info',
                                            allowOutsideClick: false,
                                            allowEscapeKey: false,
                                            allowEnterKey: false,
                                            onOpen: () => {
                                                swal.showLoading()
                                            }
                                        })
                                        var stop = i + 1;
                                        if (stop == list_show.length) {
                                        }
                                        var x = document.getElementById("aktifasi");
                                        if (x.innerHTML === "Aktifkan") {
                                            x.innerHTML = "Non-Aktifkan";
                                        };

                                    },
                                    error: function () {
                                        swal.fire("", "Failed Send Data", "error");
                                    },
                                });
                                setTimeout(function timer() { }, i * 3000);
                            }
                            get_id_biodata($('#biodId').val());
                            $('#aktif').modal('hide');
                            $('#detailVacancy').modal('show');
                        })
                    },
                    error: function () {
                        swal.fire("", "Failed Fetch Last Id", "error");
                    }
                })
            },
            error: function () {
                swal.fire("Aktifasi Gagal", "", "error");
            }
        })

        var nama = $('#namaorang').val();
        var uname = $('#uname').val();
        var pass = $('#pass').val();
        var email = $('#email').val();

        if (uname == "" && pass == "") {
            var uname = $('#abuid').val();
            var pass = $('#abpwd').val();
        };

        var sub = "Akun Tes Online Untuk Rekruitasi PT. XSIS MITRA UTAMA (No Reply)"
        var bod = "<h2>Dear, " + nama + "</h2><br>" +
            "<h4>Berikut akun untuk mengikuti tes online : </h4><br>" +
            "<p style=text-indent=50px> Username: " + uname + "<br>" +
            "<p style=text-indent=50px> Password: " + pass + "<br>"
        var datasendemail = {
            to: email,
            subject: sub,
            text: bod,
        }
        $.ajax({
            url: 'api/sending/email',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(datasendemail),
            success: function (resltsendemail) {

                swal.hideLoading();
                swal.fire({
                    title: 'Success',
                    text: "Email Sending Successfully",
                    icon: 'success',
                })
                get_id_biodata($('#biodId').val());
                $('#detailVacancy').modal('show');
            },
            error: function (e) {
                swal.hideLoading();
                swal.fire({
                    title: 'Opps...',
                    text: 'Error While Sending Email, Try Again',
                    icon: 'error',
                });

            }
        })

    }
})

$(() => {
    get_jenis_test();
});
get_jenis_test = () => {
    $.ajax({
        url: 'api/type/',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">- Pilih -</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
            }
            $("#pilihTest").html(optValue);

        },
        error: function () {
            swal.fire("Error!", "Fetch Type Test Failed", "error");
        }
    })
}

$(() => {
    get_jenis_test_type();
});
get_jenis_test_type = () => {
    $.ajax({
        url: 'api/type/',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">- Pilih -</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value="${result[i].id}">${result[i].name}</option>`;
            }
            $("#pilihTestType").html(optValue);
        },
        error: function () {
            swal.fire("Error!", "Fetch Type Test Failed", "error");
        }
    })
}

$(() => {
    get_entry_year_organisasi();
});
get_entry_year_organisasi = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    $("#entryYearOrganisasi").html("");
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#entryYearOrganisasi").append(value_year);
}

$(() => {
    get_exit_year_organisasi();
});
get_exit_year_organisasi = () => {
    $(document).ready(function () {
        $('#entryYearOrganisasi').on('change', function () {
            var current_year = new Date();
            var year = current_year.getFullYear();
            var value_year = "";
            value_year += '<option value="">- Pilih -</option>';
            $("#exitYearOrganisasi").html("");
            if (this.value == "") {

            } else {
                var j = this.value;
                while (j <= year) {
                    value_year += `<option value="` + j + `">` + j + `</option>`;
                    j++;
                }
            }
            $("#exitYearOrganisasi").append(value_year);
        });
    });
}

$(() => {
    edget_entry_year();
});
edget_entry_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#edentryYear").html(value_year);
}


$(() => {
    edget_exit_year();
});
edget_exit_year = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih -</option>';
    var j = 1990;
    while (j <= year) {

        value_year += `<option value="` + j + `">` + j + `</option>`;
        j++;
    }
    $("#edexitYear").html(value_year);
    $('#edentryYear').on('change', function () {
        var current_year = new Date();
        var year = current_year.getFullYear();
        var value_year = "";
        value_year += '<option value="">- Pilih Tahun -</option>';
        if (this.value == "") {

        } else {
            var j = this.value;
            while (j <= year) {
                value_year += `<option value="` + j + `">` + j + `</option>`;
                j++;
            }
        }
        $("#edexitYear").html(value_year);
    });
}

function get_id_organisasi_edit(vacancyId) {
    $('#detailVacancy').modal('hide');
    $.ajax({
        url: 'api/organisasi/' + vacancyId,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {
            // eget_graduation_year(res.graduationYear),
            $('#eidor').val(res.id),
                $('#edbioId').val(res.biodataId),
                $('#edOrgName').val(res.name),
                $('#edPosition').val(res.position),
                $('#edentryYear').val(res.entryYear),
                $('#edexitYear').val(res.exitYear),
                $('#edresp').val(res.responsibility),
                $('#ednotes').val(res.notes)
        },
        error: () => {
            swal.fire("Error!", "Fetch Data Organisasi", "error");
        }
    })
}

function get_id_organisasi_delete(vacancyId, name, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Organisasi ?',
        text: "Anda yakin ingin menghapus " + name + "?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/organisasi/' + vacancyId,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(id);
                    swalWithBootstrapButtons.fire('Deleted!', 'Your data has been deleted.', 'success')

                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-organisasi-list').addClass("active");
                    $('#list-organisasi').addClass("show active");

                    $('#detailVacancy').modal('show');
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

            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-organisasi-list').addClass("active");
            $('#list-organisasi').addClass("show active");

            $('#detailVacancy').modal('show');
        }
    })
}

function get_onlineTest_delete(vacancyId, periodCode, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Test ?',
        text: "Anda yakin ingin menghapus " + periodCode + "?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/onlineTest/' + vacancyId,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(id);
                    swalWithBootstrapButtons.fire('Deleted!', 'Your data has been deleted.', 'success')

                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-aktivasi-akun-list').addClass("active");
                    $('#list-aktivasi-akun').addClass("show active");

                    $('#detailVacancy').modal('show');
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

            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-aktivasi-akun-list').addClass("active");
            $('#list-aktivasi-akun').addClass("show active");
            $('#detailVacancy').modal('show');
        }
    })
}

function get_id_dokumen_edit(vacancyId) {
    $('#detailVacancy').modal('hide');
    $.ajax({
        url: 'api/dokumen/' + vacancyId,
        type: 'get',
        contentType: 'application/json',
        success: (res) => {
            $('#edid').val(res.id);
            $('#ebioId').val(res.biodataId);
            $('#efileName').val(res.fileName);
            $('#edocNotes').val(res.notesDoc);
            document.getElementById("ephotoPreview").src = "../../images/field.png";
        },
        error: () => {
            swal.fire("Error!", "Fetch Data Dokumen", "error");
        }
    })
}

function get_id_dokumen_delete(vacancyId, fileName, id) {
    $('#detailVacancy').modal('show');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Dokumen ?',
        text: "Anda yakin ingin menghapus " + fileName + "?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/dokumen/' + vacancyId,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(id);
                    swalWithBootstrapButtons.fire('Deleted!', 'Your data has been deleted.', 'success')
                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-dokumen-list').addClass("active");
                    $('#list-dokumen').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
            })
        } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
        ) {
            get_id_biodata(id);
            swalWithBootstrapButtons.fire('Cancelled', 'Your data file is safe :)', 'error')
            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-organisasi-list').addClass("active");
            $('#list-organisasi').addClass("show active");
            $('#detailVacancy').modal('show');
        }
    })
}

$('#AddDoc').on('hidden.bs.modal', function () {

    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-dokumen-list').addClass("active");
    $('#list-dokumen').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#EditDoc').on('hidden.bs.modal', function () {

    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-dokumen-list').addClass("active");
    $('#list-dokumen').addClass("show active");

    $('#detailVacancy').modal('show');
});


$('#AddOrg').on('hidden.bs.modal', function () {

    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-organisasi-list').addClass("active");
    $('#list-organisasi').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#editDataOrg').on('hidden.bs.modal', function () {


    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");


    $('#list-organisasi-list').addClass("active");
    $('#list-organisasi').addClass("show active");

    $('#detailVacancy').modal('show');
});
// Organisasi, Document, & Activation Account

// Catatan, Keahlian, dan Keluarga
function saveBtnToken() {
    $('#tokenSend').attr("disabled", true);
    var data = getFormDataKe($('#formST'));
    if ($("#formST").parsley().validate()) {
        $.ajax({
            url: 'rest/biodata',
            type: 'patch',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                swal.fire("Success!", "Success to Send Token", "success");
                $('#formST input[type=text]').val("");
                $('#sendToken').modal('hide');
            },
            error: (err) => {
                swal.fire("Error!", "Failed to Send Token", "error");
                $('#sendToken').modal('hide');
            }
        })
    }
}

function tokenDate() {
    var x = Math.floor(Math.random() * 10000000000);
    $('#updateToken').val(x);
}


$(document).ready(function () {
    getDate();
});

function getDate() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd
    }

    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    $("#updateExpiredToken").attr('min', today);
}


function getFormDataCat($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });
    return indexed_array;
}

$('#saveBtnCat').click(() => {
    var data = getFormDataCat($('#formDataCat'));
    var id = $('#bioidCat').val();
    $.ajax({
        url: 'rest/catatan',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: (res) => {
            swal.fire("Success!", "Success to Add Data", "success")
            $('#formDataCat input[type=text]').val("")
            $('#addDataCat').modal('hide');
            get_id_biodata(id);

            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-catatan-list').addClass("active");
            $('#list-catatan').addClass("show active");

            $('#detailVacancy').modal('show');
        },
        error: () => {
            swal.fire("Error!", "Failed to Add Data", "error")
        }
    })
})

function showEditFormCat(id) {
    $.ajax({
        url: 'rest/catatan/' + id,
        type: 'get',
        success: function (res) {
            $('#get_id_cat').val(res.id);
            $('#editTitle').val(res.title);
            $('#editNotes').val(res.notes);
            $.ajax({
                url: 'rest/tipecatatan',
                type: 'get',
                contentType: "application/json",
                success: function (result) {
                    var optValue = "";
                    $("#editNoteTypeId").html("");
                    optValue += '<option value="">Choose...</option>';
                    for (var i = 0; i < result.length; i++) {
                        if (result[i].id == res.noteTypeId) {
                            optValue += `<option value = ${result[i].id} selected="selected">${result[i].name}</option>`;
                        } else {
                            optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                        }
                    }
                    $("#editNoteTypeId").append(optValue);
                }
            })
            $('#editModalCat').modal();
        },
        dataType: 'json',
        contentType: 'application/json',
        error: function (err) {
        }
    })
}

$('#editBtnCat').click(() => {
    var data = getFormDataCat($('#formEditCat'));
    var id = $('#bioidCat').val();
    $.ajax({
        url: 'rest/catatan/',
        type: 'put',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: (res) => {
            swal.fire("Success!", "Success to Edit Data", "success")
            $('#formEditCat input[type=text]').val("")
            get_id_biodata(id);
            $('#editModalCat').modal('hide');
            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-catatan-list').addClass("active");
            $('#list-catatan').addClass("show active");

            $('#detailVacancy').modal('show');
        },
        error: () => {
            swal.fire("Error!", "Failed to Edit Data", "error")
        }
    })
});


function deleteActionCat(e) {
    var result = confirm("Want to delete?");
    var id = $('#bioidCat').val();
    if (result) {
        $.ajax({
            url: 'rest/catatan/' + e.value,
            type: 'delete',
            contentType: 'application/json',
            success: () => {
                get_id_biodata(id);
                swal.fire("Success!", "Success to Delete Data", "success")
                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-catatan-list').addClass("active");
                $('#list-catatan').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: () => {
                swal.fire("Error!", "Failed to Delete Data", "error")
            },
        })
    }
}

$('#showAddDataCat').click(() => {
    get_addtipecatatan();
})

function get_addtipecatatan() {
    $.ajax({
        url: 'rest/tipecatatan',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            $("#noteTypeId").html("");
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
            }
            $("#noteTypeId").append(optValue);
        }
    })
}


function get_edittipecatatan() {
    $.ajax({
        url: 'rest/tipecatatan',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            $("#editNoteTypeId").html("");
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
            }
            $("#editNoteTypeId").append(optValue);
        }
    })
}

$(() => {
    get_date();
});

function get_date() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd
    }

    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    $("#addDob").attr('max', today);
    $("#editDob").attr('max', today);
}

function formSaveKel() {
    get_addlevelpendidikan();
    get_addtipekeluarga();
    get_addhubungankeluarga();
}

function getFormDataKel($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

$('#saveBtnKel').click(() => {
    var data = getFormDataKel($('#formDataKel'));
    if ($("#formDataKel").parsley().validate()) {
        $.ajax({
            url: 'rest/keluarga',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                swal.fire("Success!", "Success to Add Data", "success")
                $('#formDataKel input[type=text]').val("");
                $('#addDataKel').modal('hide');
                get_id_biodata($('#bioidKel').val());
                $('#addFamilyTreeTypeId').val("");
                $('#addFamilyRelationId').val("");
                $('#addName').val("");
                $('#addGender').val("");
                $('#addDob').val("");
                $('#addEducationLevelId').val("");
                $('#addJob').val("");
                $('#addNotes').val("");
                $('#addDataKel').modal('hide');
                $('#editModalKel').modal('hide');

                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-keluarga-list').addClass("active");
                $('#list-keluarga').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: () => {
                swal.fire("Error!", "Failed to Add Data", "error")
            }
        })
    }
})

function showEditFormKel(id) {
    get_editlevelpendidikan();
    get_edittipekluarga();
    $.ajax({
        url: 'rest/keluarga/' + id,
        type: 'get',
        success: function (res) {
            get_edithubungankeluarga(res.familyTreeTypeId, res.familyRelationId);
            $('#get_idKel').val(res.id);
            var jk = res.gender.toString();
            $('#editFamilyTreeTypeId').val(res.familyTreeTypeId);
            $('#editName').val(res.name);
            $('#editGender').val(jk);
            $('#editDob').val(res.dob);
            $('#editEducationLevelId').val(res.educationLevelId);
            $('#editJob').val(res.job);
            $('#editNotes').val(res.notes);
            $('#editModalKel').modal('show');
        },
        dataType: 'json',
        contentType: 'application/json',
        error: function (err) {
            swal.fire("Error!", "Failed Fetch Data Keluarga", "error")
        }
    })
}

function getFormDataKe($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });
    return indexed_array;
}

$('#editBtnKel').click(() => {
    var data = getFormDataKe($('#formEditKel'));
    var id = $('#bioidKel').val();
    if ($("#formEditKel").parsley().validate()) {
        $.ajax({
            url: 'rest/keluarga/',
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                swal.fire("Success!", "Success to Edit Data", "success");
                $('#formEditKel input[type=text]').val("");
                $('#editModalKel').modal('hide');
                get_id_biodata(id);

                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-keluarga-list').addClass("active");
                $('#list-keluarga').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: function (err) {
                swal.fire("Error!", "Failed to Edit Data", "error")
            }
        })
    }
});

function deleteActionKel(e) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'rest/keluarga/' + e.value,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata($('#bioid').val());
                    swal.fire("Success!", "Success to Delete Data", "success")
                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-keluarga-list').addClass("active");
                    $('#list-keluarga').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
                error: () => {
                    swal.fire("Error!", "Failed to Delete Data", "error")
                },
            })
        }
    })
}

function closeModalKel() {
    $('#addFamilyTreeTypeId').val("");
    $('#addFamilyRelationId').val("");
    $('#addName').val("");
    $('#addGender').val("");
    $('#addDob').val("");
    $('#addEducationLevelId').val("");
    $('#addJob').val("");
    $('#addNotes').val("");
    $('#addDataKel').modal('hide');
    $('#editModalKel').modal('hide');
}

//level pendidikan
function get_addlevelpendidikan() {
    $("#addEducationLevelId").html("");
    $.ajax({
        url: 'rest/levelpendidikan',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            for (var i = 0; i < result.length; i++) {
                if (result[i].id == 7) {
                    optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                }
            }
            for (var i = 0; i < result.length; i++) {
                if (result[i].id != 7) {
                    optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                }
            }
            $("#addEducationLevelId").html(optValue);
        }
    })
}

function get_editlevelpendidikan() {
    $("#editEducationLevelId").html("");
    $.ajax({
        url: 'rest/levelpendidikan',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            for (var i = 0; i < result.length; i++) {
                if (result[i].id == 7) {
                    optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                }
            }
            for (var i = 0; i < result.length; i++) {
                if (result[i].id != 7) {
                    optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                }
            }
            $("#editEducationLevelId").html(optValue);
        }
    })
}

//tipe keluarga
function get_addtipekeluarga() {
    $.ajax({
        url: 'rest/tipekeluarga',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
            }
            $("#addFamilyTreeTypeId").html(optValue);
        }
    })
}

function get_edittipekluarga() {
    $.ajax({
        url: 'rest/tipekeluarga',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
            }
            $("#editFamilyTreeTypeId").html(optValue);
        }
    })
}

//hubungan keluarga
function get_addhubungankeluarga(id) {
    var id = id.value;
    $.ajax({
        url: 'rest/hubungankeluarga/tipe/' + id,
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].relation}</option>`;
            }
            $("#addFamilyRelationId").html(optValue);
        }
    })
}

function get_edithubungankeluarga_change(id) {
    var id = id.value;
    $("#editFamilyRelationId").html("");
    $.ajax({
        url: 'rest/hubungankeluarga',
        type: 'get',
        async: false,
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                if (result[i].familyTreeTypeId == id) {
                    optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                }
            }
            $("#editFamilyRelationId").html(optValue);
        }
    })
}

function get_edithubungankeluarga(id, id123) {
    var id123 = id123.toString();
    $("#editFamilyRelationId").html("");
    $.ajax({
        url: 'rest/hubungankeluarga',
        type: 'get',
        async: false,
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                if (result[i].familyTreeTypeId == id) {
                    optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
                }
            }
            $("#editFamilyRelationId").html(optValue);
        }
    })
    modal_show(id123);
}

function modal_show(id123) {
    $('#editFamilyRelationId').val(id123);
}

function formSaveKe() {
    get_addlevelkeahlian();
}

$('#saveBtnKe').click(() => {
    var data = getFormDataKe($('#formDataKe'));
    var id = $('#bioidKe').val();

    if ($("#formDataKe").parsley().validate()) {
        $.ajax({
            url: 'rest/keahlian',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (res) => {
                swal.fire("Success!", "Success to Add Data", "success")
                $('#formDataKe input[type=text]').val("");
                $('#addDataKe').modal('hide');
                get_id_biodata($('#bioidKe').val());
                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-keahlian-list').addClass("active");
                $('#list-keahlian').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: () => {
                swal.fire("Error!", "Failed to Add Data", "error")
            }
        })
    }
})

function showEditFormKe(id) {
    get_edittipecatatan();
    get_editlevelkeahlian();
    $.ajax({
        url: 'rest/keahlian/' + id,
        type: 'get',
        success: function (res) {
            $('#get_idKe').val(res.id);
            $('#editSkillName').val(res.skillName);
            $('#editSkillLevelId').val(res.skillLevelId);
            $('#editNotesKe').val(res.notes)
            $('#editModalKe').modal('show');
        },
        dataType: 'json',
        contentType: 'application/json',
        error: function (err) {
            swal.fire("Error!", "Get Data Detail Keahlian", "error")
        }
    })
}

$('#editBtnKe').click(() => {
    var data = getFormDataKe($('#formEditKe'));
    var id = $('#bioidKe').val();
    if ($("#formEditKe").parsley().validate()) {
        $.ajax({
            url: 'rest/keahlian/',
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                swal.fire("Success!", "Success to Edit Data", "success");
                $('#formEditKe input[type=text]').val("");
                $('#editModalKe').modal('hide');
                get_id_biodata(id);
                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-keahlian-list').addClass("active");
                $('#list-keahlian').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: function (err) {
                swal.fire("Error!", "Failed to Edit Data", "error")
            }
        })
    }
});

function deleteActionKe(e) {
    var id = $('#bioidKe').val();
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'rest/keahlian/' + e.value,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(id);
                    swal.fire("Success!", "Success to Delete Data", "success")
                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-keahlian-list').addClass("active");
                    $('#list-keahlian').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
                error: () => {
                    swal.fire("Error!", "Failed to Delete Data", "error")
                },
            })
        }
    })
}

function closeModalKe() {
    $('#addDataKe').modal('hide');
    $('#editModalKe').modal('hide');
}

//level keahlian
function get_addlevelkeahlian() {
    $.ajax({
        url: 'rest/levelkeahlian',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
            }
            $("#skillLevelId").html(optValue);
        }
    })
}

function get_editlevelkeahlian() {
    $.ajax({
        url: 'rest/levelkeahlian',
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            var optValue = "";
            optValue += '<option value="">Choose...</option>';
            for (var i = 0; i < result.length; i++) {
                optValue += `<option value = ${result[i].id}>${result[i].name}</option>`;
            }
            $("#editSkillLevelId").html(optValue);
        }
    })
}

// Catatan, Keahlian, dan Keluarga

// Lain-lain, Sertifikasi, Pengalaman Kerja
$(document).ready(function () {
    $('#validStartYear').on('change', function () {
        if ($("#validStartYear").val() == "") {
            $('#untilYear').prop("disabled", true);
        } else if ($("#validStartYear").val() != "") {
            $('#untilYear').prop("disabled", false);
        }
    })
    $('#validStartMonth').on('change', function () {
        if ($("#validStartMonth").val() == "") {
            $('#untilMonth').prop("disabled", true);
        } else if ($("#validStartMonth").val() != "") {
            $('#untilMonth').prop("disabled", false);
        }
    })
})

$(() => {
    get_start_year_sertifikasi();
});
get_start_year_sertifikasi = () => {
    var current_year = new Date();
    var year = current_year.getFullYear();
    var value_year = "";
    value_year += '<option value="">- Pilih Tahun -</option>';
    var i = 1990;
    while (i <= year) {
        value_year += `<option value="` + i + `">` + i + `</option>`;
        i++;
    }
    $("#validStartYear").html(value_year);
}

$(() => {
    get_until_year_sertifikasi();
});
get_until_year_sertifikasi = () => {
    $(document).ready(function () {
        if ($("#action").val() != "add") {
            var curr_year = new Date();
            var yr = curr_year.getFullYear();
            var val_year = "";
            val_year += '<option value="">- Pilih Tahun -</option>';
            var k = 1990;
            while (k <= (yr + 10)) {
                val_year += `<option value="` + k + `">` + k + `</option>`;
                k++;
            }
            $("#untilYear").html(val_year);
        }
        $('#validStartYear').on('change', function () {
            if ($("#validStartYear").val() == "") {
                $('#untilYear').prop("disabled", true);
            } else if ($("#validStartYear").val() != "") {
                $('#untilYear').prop("disabled", false);
            }
            var current_year = new Date();
            var year = current_year.getFullYear();
            var value_year = "";
            value_year += '<option value="">- Pilih Tahun -</option>';
            var j = this.value;
            while (j <= (year + 10)) {
                value_year += `<option value="` + j + `">` + j + `</option>`;
                j++;
            }
            $("#untilYear").html(value_year);
        });
    });
}

$('#showAddDataSertifikasi').click(() => {
    $('#untilYear').prop("disabled", true);
    $('#untilMonth').prop("disabled", true);
    $("#actionsertifikasi").val("add");
    $('#formData input[type=text]').val("");
    $('#formData textarea[type=text]').val("");
    var temp = "";
    $("#validStartYear").val(temp);
    $("#validStartMonth").val(temp);
    $("#untilYear").val(temp);
    $("#untilMonth").val(temp);
    $('#detailVacancy').modal('hide');
    $('#addDataSertifikasi').modal('show');
})

function get_data_by_id(id, action) {
    $('#detailVacancy').modal('hide');
    $('#actionsertifikasi').val(action);
    $.ajax({
        url: 'api/alfia/sertifikasi/' + id,
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            $("#id").val(result.id);
            $("#biodataId").val(result.biodataId);
            $("#certificateName").val(result.certificateName);
            $("#publisher").val(result.publisher);
            $("#validStartYear").val(result.validStartYear);
            $("#validStartMonth").val(result.validStartMonth);
            $("#untilYear").val(result.untilYear);
            $("#untilMonth").val(result.untilMonth);
            $("#notes").val(result.notes);
            if (action == "edit") {
                $(".get_certificate").attr("disabled", false);
            }
            if ($("#untilYear").val() == "") {
                $('#untilYear').prop("disabled", true);
            }
            if ($("#untilMonth").val() == "") {
                $('#untilMonth').prop("disabled", true);
            }
            $("#addDataSertifikasi").modal("show");
        },
        error: function () {
            alert("Failed to Fetch the data");
        }
    });
};

$("#saveBtnSertifikasi").click(function () {
    var action = $("#actionsertifikasi").val();
    var $form = $("#formData");
    var bioId = $("#biodataId").val();
    var data = {
        id: $("#id").val(),
        biodataId: $("#biodataId").val(),
        certificateName: $("#certificateName").val(),
        publisher: $("#publisher").val(),
        validStartYear: $("#validStartYear").val(),
        validStartMonth: $("#validStartMonth").val(),
        untilYear: $("#untilYear").val(),
        untilMonth: $("#untilMonth").val(),
        notes: $("#notes").val(),
    }
    if (action == "add") {
        type = 'post';
    } else if (action == "edit") {
        type = 'put';
    }
    var a = 1; var b = 1;
    var blnstart = parseInt($("#validStartMonth").val());
    var blnend = parseInt($("#untilMonth").val());
    if ($("#certificateName").val() == "") {
        a = 0;
    } else if ($("#publisher").val() == "") {
        a = 0;
    } else if ($("#validStartYear").val() == $("#untilYear").val()) {
        if (blnstart > blnend) {
            b = 0;
        }
    } else if ($("#validStartYear").val() > $("#untilYear").val()) {
        b = 0;
    }

    if (a == 0) {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error")
    } else if (b == 0) {
        swal.fire("BERLAKU SAMPAI TIDAK BOLEH SEBELUM DARI BERLAKU MULAI", "", "error");
    } else {
        $.ajax({
            url: 'api/alfia/sertifikasi',
            type: type,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                swal.fire("Data Berhasil Disimpan", "", "success");
                get_id_biodata(bioId);
                $("#addDataSertifikasi").modal("hide");
                $("#actionsertifikasi").val("");
                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-sertifikasi-list').addClass("active");
                $('#list-sertifikasi').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: function () {
                swal.fire("Data Gagal Disimpan", "", "error")
                $("#detailVacancy").modal("show");
            }
        })
    }
})

function hapus(bioId, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Sertifikasi',
        text: "Anda yakin ingin menghapus Referensi?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/alfia/sertifikasi/' + id,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(bioId);
                    $("#actionsertifikasi").val("");
                    swalWithBootstrapButtons.fire(
                        'Deleted!',
                        'Your data has been deleted.',
                        'success'
                    )
                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-sertifikasi-list').addClass("active");
                    $('#list-sertifikasi').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
            })
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your data file is safe :)',
                'error'
            )
            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-sertifikasi-list').addClass("active");
            $('#list-sertifikasi').addClass("show active");

            $('#detailVacancy').modal('show');
        }
    })
}

function deleteProyek(bioId, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Proyek',
        text: "Anda yakin ingin menghapus Proyek?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/proyek/' + id,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(bioId);
                    swalWithBootstrapButtons.fire(
                        'Deleted!',
                        'Your data has been deleted.',
                        'success'
                    )
                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-pengalaman-kerja-list').addClass("active");
                    $('#list-pengalaman-kerja').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
            })
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your data file is safe :)',
                'error'
            )
            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-pengalaman-kerja-list').addClass("active");
            $('#list-pengalaman-kerja').addClass("show active");

            $('#detailVacancy').modal('show');
        }
    })
}

$('#showAddRef').click(() => {
    $("#act").val("add");
    $('#formDataRef input[type=text]').val("");
    $('#detailVacancy').modal('hide');
    $('#addRefe').modal('show');
})

function get_data_ref_by_id(biodataId, id, act) {
    $('#detailVacancy').modal('hide');
    $('#act').val(act);
    $.ajax({
        url: 'api/alfia/referensi/' + id,
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            $("#id").val(result.id);
            $("#biodataId").val(result.biodataId);
            $("#nameref").val(result.name);
            $("#position").val(result.position);
            $("#addressPhone").val(result.addressPhone);
            $("#relation").val(result.relation);
            if (act == "edit") {
                $(".get_referensi").attr("disabled", false);
            }
            $("#addRefe").modal("show");
        },
        error: function () {
            alert("Failed to Fetch the data");
        }
    });
};

$("#saveBtnRef").click(function () {
    var act = $("#act").val();
    var $form = $("#formDataRef");
    var bioId = $("#biodataId").val();
    var data = {
        id: $("#id").val(),
        biodataId: $("#biodataId").val(),
        name: $("#nameref").val(),
        position: $("#position").val(),
        addressPhone: $("#addressPhone").val(),
        relation: $("#relation").val(),
    }
    if (act == "add") {
        type = 'post';
    } else if (act == "edit") {
        type = 'put';
    }
    if ($("#nameref").val() == "") {
        swal.fire("DATA NAMA REFERANSI TIDAK BOLEH KOSONG", "", "error");
    } else {
        $.ajax({
            url: 'api/alfia/referensi',
            type: type,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                swal.fire("Data Berhasil Disimpan", "", "success");
                get_id_biodata(bioId);
                $("#addRefe").modal("hide");
                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-lain-lain-list').addClass("active");
                $('#list-lain-lain').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: function () {
                swal.fire("Data Gagal Disimpan", "", "error")
                $("#detailVacancy").modal("show");
            }
        })
    }
})

function hapusrefe(bioId, id) {
    $('#detailVacancy').modal('hide');
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: 'btn btn-danger',
            cancelButton: 'btn btn-warning'
        },
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: 'Hapus Referensi',
        text: "Anda yakin ingin menghapus Referensi?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Ya',
        cancelButtonText: 'Tidak',
        reverseButtons: true
    }).then((result) => {
        if (result.value) {
            $.ajax({
                url: 'api/alfia/referensi/' + id,
                type: 'delete',
                contentType: 'application/json',
                success: () => {
                    get_id_biodata(bioId);
                    swalWithBootstrapButtons.fire(
                        'Deleted!',
                        'Your data has been deleted.',
                        'success'
                    )
                    $('#list-profile-list').removeClass("active");
                    $('#list-profile').removeClass("show active");

                    $(".list-group-item-action").removeClass("active");
                    $(".tab-pane").removeClass("show active");


                    $('#list-lain-lain-list').addClass("active");
                    $('#list-lain-lain').addClass("show active");

                    $('#detailVacancy').modal('show');
                },
            })
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire(
                'Cancelled',
                'Your data file is safe :)',
                'error'
            )
            $('#list-profile-list').removeClass("active");
            $('#list-profile').removeClass("show active");

            $(".list-group-item-action").removeClass("active");
            $(".tab-pane").removeClass("show active");


            $('#list-lain-lain-list').addClass("active");
            $('#list-lain-lain').addClass("show active");

            $('#detailVacancy').modal('show');
        }
    })
}


$(document).ready(function () {
    $('#isApplyOtherPlace').on('change', function () {
        if ($("#isApplyOtherPlace").is(':checked')) {
            $('#applyPlace').prop("disabled", false);
            $('#selectionPhase').prop("disabled", false);
        } else {
            $('#applyPlace').prop("disabled", true);
            $('#selectionPhase').prop("disabled", true);
            $('#applyPlace').val("");
            $('#selectionPhase').val("");
        }
    })
    $('#isEverBadlySick').on('change', function () {
        if ($("#isEverBadlySick").is(':checked')) {
            $('#diseaseName').prop("disabled", false);
            $('#diseaseTime').prop("disabled", false);
        } else {
            $('#diseaseName').prop("disabled", true);
            $('#diseaseTime').prop("disabled", true);
            $('#diseaseName').val("");
            $('#diseaseTime').val("");
        }
    })
    $('#isEverPsychotest').on('change', function () {
        if ($("#isEverPsychotest").is(':checked')) {
            $('#psychotestNeeds').prop("disabled", false);
            $('#psychotestTime').prop("disabled", false);
        } else {
            $('#psychotestNeeds').prop("disabled", true);
            $('#psychotestTime').prop("disabled", true);
            $('#psychotestNeeds').val("");
            $('#psychotestTime').val("");
        }
    })
})

$('#showEditKet').click(function () {
    $("#actionket").val("edit");
    $('#detailVacancy').modal('hide');
    var id = $('#idketam').val();
    if (id == "") {
        $('#formDataKet input[type=text]').val("");
        $('#formDataKet textarea[type=text]').val("");
        $('#EditKet').modal('show');
    } else {
        $.ajax({
            url: 'api/alfia/keterangantambahan/' + id,
            type: 'get',
            contentType: 'application/json',
            success: function (result) {
                $("#id").val(result.id);
                $("#biodataId").val(result.biodataId);
                $("#emergencyContactName").val(result.emergencyContactName);
                $("#expectedSalary").val(result.expectedSalary);
                if (result.isNegotiable == true) {
                    $("#isNegotiable").prop("checked", true);
                } else {
                    $("#isNegotiable").prop("checked", false);
                }
                $("#isNegotiable").val(result.isNegotiable);
                $("#emergencyContactPhone").val(result.emergencyContactPhone);
                $("#startWorking").val(result.startWorking);
                if (result.isReadyToOutoftown == true) {
                    $("#isReadyToOutoftown").prop("checked", true);
                } else {
                    $("#isReadyToOutoftown").prop("checked", false);
                }
                $("#isReadyToOutoftown").val(result.isReadyToOutoftown);
                if (result.isApplyOtherPlace == true) {
                    $("#isApplyOtherPlace").prop("checked", true);
                    $('#applyPlace').prop("disabled", false);
                    $('#selectionPhase').prop("disabled", false);
                    $("#applyPlace").val(result.applyPlace);
                    $("#selectionPhase").val(result.selectionPhase);
                } else {
                    $("#isApplyOtherPlace").prop("checked", false);
                    $('#applyPlace').prop("disabled", true);
                    $('#selectionPhase').prop("disabled", true);
                    $("#applyPlace").val("");
                    $("#selectionPhase").val("");
                }
                $("#isApplyOtherPlace").val(result.isApplyOtherPlace);
                if (result.isEverBadlySick == true) {
                    $("#isEverBadlySick").prop("checked", true);
                    $('#diseaseName').prop("disabled", false);
                    $('#diseaseTime').prop("disabled", false);
                    $("#diseaseName").val(result.diseaseName);
                    $("#diseaseTime").val(result.diseaseTime);
                } else {
                    $("#isEverBadlySick").prop("checked", false);
                    $('#diseaseName').prop("disabled", true);
                    $('#diseaseTime').prop("disabled", true);
                    $("#diseaseName").val("");
                    $("#diseaseTime").val("");
                }
                $("#isEverBadlySick").val(result.isEverBadlySick);
                if (result.isEverPsychotest == true) {
                    $("#isEverPsychotest").prop("checked", true);
                    $('#psychotestNeeds').prop("disabled", false);
                    $('#psychotestTime').prop("disabled", false);
                    $("#psychotestNeeds").val(result.psychotestNeeds);
                    $("#psychotestTime").val(result.psychotestTime);
                } else {
                    $("#isEverPsychotest").prop("checked", false);
                    $('#psychotestNeeds').prop("disabled", true);
                    $('#psychotestTime').prop("disabled", true);
                    $("#psychotestNeeds").val("");
                    $("#psychotestTime").val("");
                }
                $("#isEverPsychotest").val(result.isEverPsychotest);
                $("#requirementesRequired").val(result.requirementesRequired);
                $("#otherNotes").val(result.otherNotes);
                // $(".get_keterangan").attr("disabled", false);
                $('#EditKet').modal('show');
            },
            error: function () {
                alert("Failed to Fetch the data");
            }
        })
    }
})

$('#showDetailKet').click(() => {
    $("#actionket").val("detail");
    $('#detailVacancy').modal('hide');
    var id = $("#idketam").val();
    $.ajax({
        url: 'api/alfia/keterangantambahan/' + id,
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            $("#expSalary").html("");
            if (id == "") {
                $("#expSalary").append('<td>-</td>');
            } else {
                $("#expSalary").append('<td>' + result.expectedSalary + '</td>');
            }

            $("#isNego").html("");
            if (result.isNegotiable == true) {
                $("#isNego").append('<td>Ya</td>');
            } else if (result.isNegotiable == false) {
                $("#isNego").append('<td>Tidak</td>');
            } else {
                $("#isNego").append('<td>-</td>');
            }

            $("#startWork").html("");
            if (id == "") {
                $("#startWork").append('<td>-</td>');
            } else {
                $("#startWork").append('<td>' + result.startWorking + '</td>');
            }

            $("#isReadyOutoftown").html("");
            if (result.isReadyToOutoftown == true) {
                $("#isReadyOutoftown").append('<td>Ya</td>');
            } else if (result.isReadyToOutoftown == false) {
                $("#isReadyOutoftown").append('<td>Tidak</td>');
            } else {
                $("#isReadyOutoftown").append('<td>-</td>');
            }

            $("#emContactName").html("");
            if (id == "") {
                $("#emContactName").append('<td>-</td>');
            } else {
                $("#emContactName").append('<td>' + result.emergencyContactName + '</td>');
            }

            $("#emContactPhone").html("");
            if (id == "") {
                $("#emContactPhone").append('<td>-</td>');
            } else {
                $("#emContactPhone").append('<td>' + result.emergencyContactPhone + '</td>');
            }

            $("#applyOtherPlace").html("");
            if (result.isApplyOtherPlace == true) {
                $("#applyOtherPlace").append('<td>Ya</td>');
            } else if (result.isApplyOtherPlace == false) {
                $("#applyOtherPlace").append('<td>Tidak</td>');
            } else {
                $("#applyOtherPlace").append('<td>-</td>');
            }

            $("#applyPlc").html("");
            if (result.isApplyOtherPlace == true) {
                $("#applyPlc").append('<td>' + result.applyPlace + '</td>');
            } else {
                $("#applyPlc").append('<td>-</td>');
            }

            $("#selectionPhs").html("");
            if (result.isApplyOtherPlace == true) {
                $("#selectionPhs").append('<td>' + result.selectionPhase + '</td>');
            } else {
                $("#selectionPhs").append('<td>-</td>');
            }

            $("#isEverSick").html("");
            if (result.isEverBadlySick == true) {
                $("#isEverSick").append('<td>Ya</td>');
            } else if (result.isEverBadlySick == false) {
                $("#isEverSick").append('<td>Tidak</td>');
            } else {
                $("#isEverSick").append('<td>-</td>');
            }

            $("#diseaseNm").html("");
            if (result.isEverBadlySick == true) {
                $("#diseaseNm").append('<td>' + result.diseaseName + '</td>');
            } else {
                $("#diseaseNm").append('<td>-</td>');
            }

            $("#diseaseTm").html("");
            if (result.isEverBadlySick == true) {
                $("#diseaseTm").append('<td>' + result.diseaseTime + '</td>');
            } else {
                $("#diseaseTm").append('<td>-</td>');
            }

            $("#isEverPsychotst").html("");
            if (result.isEverPsychotest == true) {
                $("#isEverPsychotst").append('<td>Ya</td>');
            } else if (result.isEverPsychotest == false) {
                $("#isEverPsychotst").append('<td>Tidak</td>');
            } else {
                $("#isEverPsychotst").append('<td>-</td>');
            }

            $("#psychotestNds").html("");
            if (result.isEverPsychotest == true) {
                $("#psychotestNds").append('<td>' + result.psychotestNeeds + '</td>');
            } else {
                $("#psychotestNds").append('<td>-</td>');
            }

            $("#psychotestTm").html("");
            if (result.isEverPsychotest == true) {
                $("#psychotestTm").append('<td>' + result.psychotestTime + '</td>');
            } else {
                $("#psychotestTm").append('<td>-</td>');
            }

            $("#otherNts").html("");
            if (id != "") {
                $("#otherNts").append('<td>' + result.otherNotes + '</td>');
            } else {
                $("#otherNts").append('<td>-</td>');
            }

            $(".get_detail_ket").attr("disabled", true);
            $("#DetailKet").modal("show");
        },
        error: function () {
            alert("Failed to Fetch the data");
        }
    })
})

$("#saveBtnKet").click(function () {
    var $form = $("#formDataKet");
    var bioId = $("#biodataId").val();
    if ($("#isNegotiable").is(':checked')) {
        $("#isNegotiable").val(true);
    } else {
        $("#isNegotiable").val(false);
    }
    if ($("#isReadyToOutoftown").is(':checked')) {
        $("#isReadyToOutoftown").val(true);
    } else {
        $("#isReadyToOutoftown").val(false);
    }
    if ($("#isApplyOtherPlace").is(':checked')) {
        $("#isApplyOtherPlace").val(true);
    } else {
        $("#isApplyOtherPlace").val(false);
    }
    if ($("#isEverBadlySick").is(':checked')) {
        $("#isEverBadlySick").val(true);
    } else {
        $("#isEverBadlySick").val(false);
    }
    if ($("#isEverPsychotest").is(':checked')) {
        $("#isEverPsychotest").val(true);
    } else {
        $("#isEverPsychotest").val(false);
    }
    var data = {
        id: $("#id").val(),
        biodataId: $("#biodataId").val(),
        emergencyContactName: $("#emergencyContactName").val(),
        expectedSalary: $("#expectedSalary").val(),
        isNegotiable: $("#isNegotiable").val(),
        emergencyContactPhone: $("#emergencyContactPhone").val(),
        startWorking: $("#startWorking").val(),
        isReadyToOutoftown: $("#isReadyToOutoftown").val(),
        isApplyOtherPlace: $("#isApplyOtherPlace").val(),
        applyPlace: $("#applyPlace").val(),
        selectionPhase: $("#selectionPhase").val(),
        isEverBadlySick: $("#isEverBadlySick").val(),
        diseaseName: $("#diseaseName").val(),
        diseaseTime: $("#diseaseTime").val(),
        isEverPsychotest: $("#isEverPsychotest").val(),
        psychotestNeeds: $("#psychotestNeeds").val(),
        psychotestTime: $("#psychotestTime").val(),
        requirementesRequired: $("#requirementesRequired").val(),
        otherNotes: $("#otherNotes").val(),
    }
    if ($("#idketam").val() == "") {
        type = 'post';
    } else if ($("#idketam").val() != "") {
        type = 'put';
    }
    var z = 1; var y = 1; var x = 1; var w = 1;
    if ($("#emergencyContactName").val() == "") {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error");
    } else if ($("#expectedSalary").val() == "") {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error");
    } else if ($("#isNegotiable").val() == "") {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error");
    } else if ($("#emergencyContactPhone").val() == "") {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error");
    } else if ($("#startWorking").val() == "") {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error");
    } else if ($("#isReadyToOutoftown").val() == "") {
        swal.fire("Kolom bertanda (*) WAJIB DIISI", "", "error");
    } else if ($("#isApplyOtherPlace").is(':checked')) {
        if ($("#applyPlace").val() == "" || $("#selectionPhase").val() == "") {
            //cek kedua
            if ($("#isEverBadlySick").is(':checked')) {
                if ($("#diseaseName").val() == "" || $("#diseaseTime").val() == "") {
                    // cek ketiga
                    if ($("#isEverPsychotest").is(':checked')) {
                        if ($("#psychotestNeeds").val() == "" || $("#psychotestTime").val() == "") {
                            swal.fire("Data Tempat Melamar, Tahapan Seleksi Melamar, Nama Penyakit, Waktu Sakit, Keperluan Psikotest, dan Waktu Psikotest WAJIB DIISI", "", "error");
                        }
                    } else {
                        swal.fire("Data Tempat Melamar, Tahapan Seleksi Melamar, Nama Penyakit, dan Waktu Sakit WAJIB DIISI", "", "error");
                    }
                }
            } else if ($("#isEverPsychotest").is(':checked')) {
                if ($("#psychotestNeeds").val() == "" || $("#psychotestTime").val() == "") {
                    swal.fire("Data Tempat Melamar, Tahapan Seleksi Melamar, Keperluan Psikotest, dan Waktu Psikotest WAJIB DIISI", "", "error");
                }
            } else {
                swal.fire("Data Tempat Melamar dan Tahapan Seleksi Melamar WAJIB DIISI", "", "error");
            }
        }
    } else if ($("#isEverBadlySick").is(':checked')) {
        if ($("#diseaseName").val() == "" || $("#diseaseTime").val() == "") {
            //cek kedua
            if ($("#isEverPsychotest").is(':checked')) {
                if ($("#psychotestNeeds").val() == "" || $("#psychotestTime").val() == "") {
                    swal.fire("Data Nama Penyakit, Waktu Sakit, Keperluan Psikotest, dan Waktu Psikotest WAJIB DIISI", "", "error");
                }
            } else {
                swal.fire("Data Nama Penyakit dan Waktu Sakit WAJIB DIISI", "", "error");
            }
        }
    } else if ($("#isEverPsychotest").is(':checked')) {
        if ($("#psychotestNeeds").val() == "" || $("#psychotestTime").val() == "") {
            // cek kedua
            if ($("#isApplyOtherPlace").is(':checked')) {
                if ($("#applyPlace").val() == "" || $("#selectionPhase").val() == "") {
                    swal.fire("Data Tempat Melamar, Tahapan Seleksi Melamar, Keperluan Psikotest, dan Waktu Psikotest WAJIB DIISI", "", "error");
                }
            } else {
                swal.fire("Data Keperluan Psikotest dan Waktu Psikotest WAJIB DIISI", "", "error");
            }
        }
    } else {
        $.ajax({
            url: 'api/alfia/keterangantambahan',
            type: type,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                swal.fire("Data Berhasil Disimpan", "", "success");
                get_id_biodata(bioId);
                $("#EditKet").modal("hide");
                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-lain-lain-list').addClass("active");
                $('#list-lain-lain').addClass("show active");

                $('#detailVacancy').modal('show');
            },
            error: function () {
                swal.fire("Data Gagal Disimpan", "", "error")
                $("#detailVacancy").modal("show");
            }
        })
    }
})

$('#addDataSertifikasi').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-sertifikasi-list').addClass("active");
    $('#list-sertifikasi').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#addDataSertifikasi').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-sertifikasi-list').addClass("active");
    $('#list-sertifikasi').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#addRefe').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-lain-lain-list').addClass("active");
    $('#list-lain-lain').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#addRefe').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-lain-lain-list').addClass("active");
    $('#list-lain-lain').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#EditKet').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-lain-lain-list').addClass("active");
    $('#list-lain-lain').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#EditKet').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-lain-lain-list').addClass("active");
    $('#list-lain-lain').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#DetailKet').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-lain-lain-list').addClass("active");
    $('#list-lain-lain').addClass("show active");

    $('#detailVacancy').modal('show');
});

$('#DetailKet').on('hidden.bs.modal', function () {
    $('#list-profile-list').removeClass("active");
    $('#list-profile').removeClass("show active");

    $(".list-group-item-action").removeClass("active");
    $(".tab-pane").removeClass("show active");

    $('#list-lain-lain-list').addClass("active");
    $('#list-lain-lain').addClass("show active");

    $('#detailVacancy').modal('show');
});

// Lain-lain, Sertifikasi, Pengalaman Kerja

function getYear() {
    for (y = 2000; y <= 2500; y++) {
        var optn = document.createElement("OPTION");
        var optp = document.createElement("OPTION");
        optn.text = y;
        optn.value = y;
        optp.text = y;
        optp.value = y;

        document.getElementById('get_pengker_tahunmas').options.add(optn);
        document.getElementById('get_pengker_tahunkel').options.add(optp);
    }
}

function deleteData(id) {
    var bioId = $("#biodataId").val();
    var data = {
        id: $("#get_pengker_id").val()
    }
    swal.fire({ text: "Delete this data ?", icon: "warning", buttons: true, dangerMode: true })
        .then((result) => {
            if (result) {
                $.ajax({
                    url: 'api/pengalamankerja-ku/' + id,
                    type: 'delete',
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (result) {
                        get_id_biodata(id);
                        swal.fire("", "Deleted Success", "success").then((value) => {
                            get_id_biodata(id);
                        });

                        $('#list-profile-list').removeClass("active");
                        $('#list-profile').removeClass("show active");

                        $(".list-group-item-action").removeClass("active");
                        $(".tab-pane").removeClass("show active");


                        $('#list-pengalaman-kerja-list').addClass("active");
                        $('#list-pengalaman-kerja').addClass("show active");

                        $('#detailVacancy').modal('show');

                    },
                    error: function () {
                        swal.fire("Opps..", "Error delete data", "error")
                    }
                });
            }
        });
}

function get_data_peker_by_id(id, action) {
    getYear();
    var bioId = $("#biodataId").val();
    $("#action").val(action);
    $.ajax({
        url: 'api/pengalamankerja-ku/' + id,
        type: 'get',
        contentType: "application/json",
        success: function (result) {
            $("#get_pengker_id").val(result.id);
            $("#biodataId").val(result.biodataId),
                $("#get_pengker_nama").val(result.companyName);
            $("#get_pengker_bulanmas").val(result.joinMonth);
            $("#get_pengker_tahunmas").val(result.joinYear);
            $("#get_pengker_posisi").val(result.lastPosition);
            $("#get_pengker_kota").val(result.city);
            $("#get_penker_negara").val(result.country);
            $("#get_pengker_bulankel").val(result.resignMonth);
            $("#get_pengker_tahunkel").val(result.resignYear);
            $("#get_pengker_penghas").val(result.income);
            $("#get_pengker_checkbox").val(result.isItRelated);
            $("#get_pengker_job").val(result.aboutJob);
            $("#get_pengker_alasan").val(result.exitReason);
            $("#get_pengker_ket").val(result.notes);

            if ($("#get_pengker_checkbox").val() == "true") {
                $("#get_pengker_checkbox").prop("checked", true);
            } else {
                $("#get_pengker_checkbox").prop("checked", false);
            }

            if ($('#get_pengker_tahunmas').val() != "" && $('#get_pengker_bulanmas').val() != "") {
                $('#get_pengker_bulankel').attr("disabled", false);
                $('#get_pengker_tahunkel').attr("disabled", false);
            } else {
                $('#get_pengker_bulankel').attr("disabled", true);
                $('#get_pengker_tahunkel').attr("disabled", true);
                $('#get_pengker_tahunkel').val("");
                $('#get_pengker_bulankel').val("");
            }
            if (action == "ubah") {

                $(".modal-title").text("Ubah Pengalaman Kerja");
                $(".get_pengker").attr("disabled", false);

                $("#modal-pengker").modal("show");

            }
            else if (action == "tambah") {
                swal.fire("", "Incoming Feature", "info")
            }

        },
        error: function () {
            swal.fire("Opps..", "Failed to fetch the data", "error");
        }
    });
}

$("#add_button_peker").click(function () {
    $(".get_pengker").val("");
    $("#get_pengker_checkbox").val(false);
    if ($("#get_pengker_checkbox").val() == "true") {
        $("#get_pengker_checkbox").prop("checked", true);
    } else {
        $("#get_pengker_checkbox").prop("checked", false);
    }
    $(".get_pengker_masuk").val("");
    $(".get_pengker_keluar").val("");
    // $('#pengalamankerja').modal('hide');
    $(".modal-title").text("Tambah Pengalaman Kerja");
    $(".get_pengker").attr("disabled", false);
    $("#get_pengker_id").val("");
    $("#action").val("tambah");
    $('.get_pengker_keluar').attr("disabled", true);
    getYear();
    $("#modal-pengker").modal("show");

})

function save_edit(type, data, action, bioId) {
    $.ajax({
        url: 'api/pengalamankerja-ku/',
        type: type,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            // $("#get_from_pengker")[0].reset();
            swal.fire("", "Berhasil " + action + " data", "success").then((value) => {
                get_id_biodata(bioId);
                $("#modal-pengker").modal("hide");

                $('#list-profile-list').removeClass("active");
                $('#list-profile').removeClass("show active");

                $(".list-group-item-action").removeClass("active");
                $(".tab-pane").removeClass("show active");


                $('#list-pengalaman-kerja-list').addClass("active");
                $('#list-pengalaman-kerja').addClass("show active");

                $('#detailVacancy').modal('show');
            });
        },
        error: function () {
            swal.fire("Opps..", "Gagal " + action + " data", "error");
        }
    })
}

$(() => {
    get_disabled();
});
get_disabled = () => {
    $(document).ready(function () {
        $(".get_pengker_masuk").on('change', function () {
            if ($('#get_pengker_tahunmas').val() != "" && $('#get_pengker_bulanmas').val() != "") {
                $('#get_pengker_bulankel').attr("disabled", false);
                $('#get_pengker_tahunkel').attr("disabled", false);
            } else {
                $('#get_pengker_bulankel').attr("disabled", true);
                $('#get_pengker_tahunkel').attr("disabled", true);
                $('#get_pengker_tahunkel').val("");
                $('#get_pengker_bulankel').val("");

            }
        })
    })
}

$("#save_button_pengker").click(function () {
    var a = ""
    var bioId = $("#biodataId").val();
    var action = $("#action").val();
    var bulanmas = parseInt($("#get_pengker_bulanmas").val());
    var bulankel = parseInt($("#get_pengker_bulankel").val());
    var tahunmas = parseInt($("#get_pengker_tahunmas").val());
    var tahunkel = parseInt($("#get_pengker_tahunkel").val());

    if ($('input.checkbox_cek').is(':checked')) {
        $("#get_pengker_checkbox").val(true)

    } else {
        $("#get_pengker_checkbox").val(false)
    }

    var data = {
        id: $("#get_pengker_id").val(),
        biodataId: $("#biodataId").val(),
        companyName: $("#get_pengker_nama").val(),
        joinMonth: $("#get_pengker_bulanmas").val(),
        joinYear: $("#get_pengker_tahunmas").val(),
        lastPosition: $("#get_pengker_posisi").val(),
        city: $("#get_pengker_kota").val(),
        country: $("#get_penker_negara").val(),
        resignMonth: $("#get_pengker_bulankel").val(),
        resignYear: $("#get_pengker_tahunkel").val(),
        income: $("#get_pengker_penghas").val(),
        isItRelated: $("#get_pengker_checkbox").val(),
        aboutJob: $("#get_pengker_job").val(),
        exitReason: $("#get_pengker_alasan").val(),
        notes: $("#get_pengker_ket").val(),
    }

    if (action == "tambah") {
        type = 'post';
    }
    else if (action == "ubah") {
        type = 'put';
    }

    if ($('#get_pengker_nama').val() != "" && $('#get_pengker_posisi').val() != "" && $('#get_pengker_bulanmas').val() != "" && $('#get_pengker_tahunmas').val() != "") {

        if ((($('#get_pengker_bulankel').val() == "") ^ ($('#get_pengker_tahunkel').val() == ""))) {
            swal.fire("Opps..", "Kolom \" Waktu Keluar (Bulan & Tahun) \" harus Diisi ", "error");

        } else {
            if ($("#get_pengker_tahunkel").val() == "" && $("#get_pengker_bulankel").val() == "") {
                save_edit(type, data, action, bioId);
            } else {
                if ($("#get_pengker_tahunmas").val() < $("#get_pengker_tahunkel").val()) {
                    save_edit(type, data, action, bioId);
                } else if ($("#get_pengker_tahunmas").val() == $("#get_pengker_tahunkel").val()) {
                    if ($("#get_pengker_bulanmas").val() < $("#get_pengker_bulankel").val()) {
                        save_edit(type, data, action, bioId);
                    }
                    else if ($("#get_pengker_bulanmas").val() == $("#get_pengker_bulankel").val()) {
                        save_edit(type, data, action, bioId);
                    } else {
                        swal.fire("Opps..", "Inputan Bulan pada Kolom \"Waktu Masuk\" Harus Lebih Kecil Dari Kolom \"Waktu Keluar\"", "error");
                    }
                } else {
                    swal.fire("Opps..", "Inputan Tahun pada Kolom \"Waktu Masuk\" Harus Lebih Kecil Dari Kolom \"Waktu Keluar\"", "error");
                }
            }
        }
    } else {
        swal.fire("Opps..", "Kolom bertanda ( * ) Merah Wajib Diisi", "error");
    }
})

$(() => {
    get_sumber();
});
get_sumber = () => {
    $(document).ready(function () {
        $("#get_sumber_loker_sumber").on('change', function () {
            if ($("#get_sumber_loker_sumber").val() == "Career Center") {
                var bioId = $("#biodataId").val();
                $(".get_sumber_loker_career_center").attr("disabled", false);
                $(".get_sumber_loker_sumber_lain").attr("disabled", true);
                $(".get_sumber_loker_refrensi").attr("disabled", true);

                $(".get_sumber_loker_career_center1").css("color", "red");
                $(".get_sumber_loker_sumber_lain1").css("color", "black");
                $(".get_sumber_loker_refrensi1").css("color", "black");

                $(".get_sumber_loker_career_center").prop('required', true);
                $(".get_sumber_loker_sumber_lain").prop('required', false);
                $(".get_sumber_loker_refrensi").prop('required', false);
                $.ajax({
                    url: 'api/sumber-loker-ku/' + bioId,
                    type: 'get',
                    contentType: 'application/json',
                    success: (result) => {
                        $("#get_sumber_loker_id").val(result.id),
                            $("#biodataId2").val(result.biodataId),
                            $("#get_sumber_loker_tipepelamar").val(result.candidateType),
                            $("#get_sumber_loker_namaevent").val(result.eventName),
                            $("#get_sumber_loker_namacareercenter").val(result.careerCenterName),
                            $("#get_sumber_loker_referrername").val(''),
                            $("#get_sumber_loker_referrerphonenumber").val(''),
                            $("#get_sumber_loker_referreremail").val(''),
                            $("#get_sumber_loker_sumberlain").val(''),
                            $("#get_sumber_loker_income").val(result.lastIncome),
                            $("#date-picker").val(result.applyDate)
                    },
                })

            } else if ($("#get_sumber_loker_sumber").val() == "Referensi") {
                var bioId = $("#biodataId").val();
                var idku = $("#get_sumber_loker_id").val();
                $(".get_sumber_loker_career_center").attr("disabled", true);
                $(".get_sumber_loker_sumber_lain").attr("disabled", true);
                $(".get_sumber_loker_refrensi").attr("disabled", false);

                $(".get_sumber_loker_career_center1").css("color", "black");
                $(".get_sumber_loker_sumber_lain1").css("color", "black");
                $(".get_sumber_loker_refrensi1").css("color", "red");

                $(".get_sumber_loker_career_center").prop('required', false);
                $(".get_sumber_loker_sumber_lain").prop('required', true);
                $(".get_sumber_loker_refrensi").prop('required', false);
                $.ajax({
                    url: 'api/sumber-loker-ku/' + bioId,
                    type: 'get',
                    contentType: 'application/json',
                    success: (result) => {
                        $("#get_sumber_loker_id").val(result.id),
                            $("#biodataId2").val(result.biodataId),
                            $("#get_sumber_loker_tipepelamar").val(result.candidateType),
                            $("#get_sumber_loker_namaevent").val(''),
                            $("#get_sumber_loker_namacareercenter").val(''),
                            $("#get_sumber_loker_referrername").val(result.referrerName),
                            $("#get_sumber_loker_referrerphonenumber").val(result.referrerPhone),
                            $("#get_sumber_loker_referreremail").val(result.referrerEmail),
                            $("#get_sumber_loker_sumberlain").val(''),
                            $("#get_sumber_loker_income").val(result.lastIncome),
                            $("#date-picker").val(result.applyDate)
                    },
                })
            } else {
                var bioId = $("#biodataId").val();
                $(".get_sumber_loker_career_center").attr("disabled", true);
                $(".get_sumber_loker_sumber_lain").attr("disabled", false);
                $(".get_sumber_loker_refrensi").attr("disabled", true);

                $(".get_sumber_loker_career_center1").css("color", "black");
                $(".get_sumber_loker_sumber_lain1").css("color", "red");
                $(".get_sumber_loker_refrensi1").css("color", "black");

                $(".get_sumber_loker_career_center").prop('required', false);
                $(".get_sumber_loker_sumber_lain").prop('required', false);
                $(".get_sumber_loker_refrensi").prop('required', true);

                $.ajax({
                    url: 'api/sumber-loker-ku/' + bioId,
                    type: 'get',
                    contentType: 'application/json',
                    success: (result) => {
                        $("#get_sumber_loker_id").val(result.id),
                            $("#biodataId2").val(result.biodataId),
                            $("#get_sumber_loker_tipepelamar").val(result.candidateType),
                            $("#get_sumber_loker_namaevent").val(''),
                            $("#get_sumber_loker_namacareercenter").val(''),
                            $("#get_sumber_loker_referrername").val(''),
                            $("#get_sumber_loker_referrerphonenumber").val(''),
                            $("#get_sumber_loker_referreremail").val(''),
                            $("#get_sumber_loker_sumberlain").val(result.otherSource),
                            $("#get_sumber_loker_income").val(result.lastIncome),
                            $("#date-picker").val(result.applyDate)
                    },
                })
            }
        })
    });
}

$("#date-picker").datetimepicker({
    timepicker: false,
    datepicker: true,
    format: 'Y-m-d'
})
$('#toggle').on('click', function () {
    $("#date-picker").datetimepicker('toggle')
})

$("#list-sumber-lowongan-kerja-list,.closeButton").click(function () {
    $("#get_sumber_loker_id").val(""),
        $("#biodataId2").val(""),
        $("#get_sumber_loker_sumber").val("- Pilih -"),
        $("#get_sumber_loker_tipepelamar").val("- Pilih -"),
        $("#get_sumber_loker_namaevent").val(""),
        $("#get_sumber_loker_namacareercenter").val(""),
        $("#get_sumber_loker_referrername").val(""),
        $("#get_sumber_loker_referrerphonenumber").val(""),
        $("#get_sumber_loker_referreremail").val(""),
        $("#get_sumber_loker_sumberlain").val(""),
        $("#get_sumber_loker_income").val(""),
        $("#date-picker").val("")
    $(".get_sumber_loker_career_center1").css("color", "black");
    $(".get_sumber_loker_sumber_lain1").css("color", "black");
    $(".get_sumber_loker_refrensi1").css("color", "black");

    $(".get_sumber_loker_career_center").attr("disabled", true);
    $(".get_sumber_loker_sumber_lain").attr("disabled", true);
    $(".get_sumber_loker_refrensi").attr("disabled", true);
    var bioId = $("#biodataId").val();
    $.ajax({
        url: 'api/sumber-loker-ku/' + bioId,
        type: 'get',
        contentType: 'application/json',
        success: (result) => {

            $("#get_sumber_loker_id").val(result.id),
                $("#biodataId2").val(result.biodataId),
                $("#get_sumber_loker_sumber").val(result.vacancySource),
                $("#get_sumber_loker_tipepelamar").val(result.candidateType),
                $("#get_sumber_loker_namaevent").val(result.eventName),
                $("#get_sumber_loker_namacareercenter").val(result.careerCenterName),
                $("#get_sumber_loker_referrername").val(result.referrerName),
                $("#get_sumber_loker_referrerphonenumber").val(result.referrerPhone),
                $("#get_sumber_loker_referreremail").val(result.referrerEmail),
                $("#get_sumber_loker_sumberlain").val(result.otherSource),
                $("#get_sumber_loker_income").val(result.lastIncome),
                $("#date-picker").val(result.applyDate)

            if ($("#get_sumber_loker_sumber").val() == "Career Center") {
                $(".get_sumber_loker_career_center").attr("disabled", false);
                $(".get_sumber_loker_sumber_lain").attr("disabled", true);
                $(".get_sumber_loker_refrensi").attr("disabled", true);

                $(".get_sumber_loker_career_center").prop('required', true);
                $(".get_sumber_loker_sumber_lain").prop('required', false);
                $(".get_sumber_loker_refrensi").prop('required', false);

                $("#get_sumber_loker_referrername").val(''),
                    $("#get_sumber_loker_referrerphonenumber").val(''),
                    $("#get_sumber_loker_referreremail").val(''),
                    $("#get_sumber_loker_sumberlain").val(''),
                    $(".get_sumber_loker_career_center1").css("color", "red");
                $(".get_sumber_loker_sumber_lain1").css("color", "black");
                $(".get_sumber_loker_refrensi1").css("color", "black");

            } else if ($("#get_sumber_loker_sumber").val() == "Referensi") {
                $(".get_sumber_loker_career_center").attr("disabled", true);
                $(".get_sumber_loker_sumber_lain").attr("disabled", true);
                $(".get_sumber_loker_refrensi").attr("disabled", false);

                $("#get_sumber_loker_namaevent").val(''),
                    $("#get_sumber_loker_namacareercenter").val(''),
                    $("#get_sumber_loker_sumberlain").val(''),

                    $(".get_sumber_loker_career_center1").css("color", "black");
                $(".get_sumber_loker_sumber_lain1").css("color", "black");
                $(".get_sumber_loker_refrensi1").css("color", "red");

                $(".get_sumber_loker_career_center").prop('required', false);
                $(".get_sumber_loker_sumber_lain").prop('required', true);
                $(".get_sumber_loker_refrensi").prop('required', false);
            } else {
                $(".get_sumber_loker_career_center").attr("disabled", true);
                $(".get_sumber_loker_sumber_lain").attr("disabled", false);
                $(".get_sumber_loker_refrensi").attr("disabled", true);

                $("#get_sumber_loker_namaevent").val(''),
                    $("#get_sumber_loker_namacareercenter").val(''),
                    $("#get_sumber_loker_referrername").val(''),
                    $("#get_sumber_loker_referrerphonenumber").val(''),
                    $("#get_sumber_loker_referreremail").val(''),

                    $(".get_sumber_loker_career_center").prop('required', false);
                $(".get_sumber_loker_sumber_lain").prop('required', false);
                $(".get_sumber_loker_refrensi").prop('required', true);

                $(".get_sumber_loker_career_center1").css("color", "black");
                $(".get_sumber_loker_sumber_lain1").css("color", "red");
                $(".get_sumber_loker_refrensi1").css("color", "black");
            }
        },
    })
})

$("#save_button_sumberloker").click(function () {
    var bioId = $("#biodataId").val();
    var type = "";
    var data = {
        id: $("#get_sumber_loker_id").val(),
        biodataId: $("#biodataId").val(),
        vacancySource: $("#get_sumber_loker_sumber").val(),
        candidateType: $("#get_sumber_loker_tipepelamar").val(),
        eventName: $("#get_sumber_loker_namaevent").val(),
        careerCenterName: $("#get_sumber_loker_namacareercenter").val(),
        referrerName: $("#get_sumber_loker_referrername").val(),
        referrerPhone: $("#get_sumber_loker_referrerphonenumber").val(),
        referrerEmail: $("#get_sumber_loker_referreremail").val(),
        otherSource: $("#get_sumber_loker_sumberlain").val(),
        lastIncome: $("#get_sumber_loker_income").val(),
        applyDate: $("#date-picker").val(),
    }
    if ($("#get_sumber_loker_id").val() == "") {
        type = 'post';
    } else {
        type = 'put';
    }
    if ($("#get_sumber_loker_sumber").val() == "Career Center") {
        $(".get_sumber_loker_career_center").attr("disabled", false);
        $(".get_sumber_loker_sumber_lain").attr("disabled", true);
        $(".get_sumber_loker_refrensi").attr("disabled", true);

        $(".get_sumber_loker_career_center").prop('required', true);
        $(".get_sumber_loker_sumber_lain").prop('required', false);
        $(".get_sumber_loker_refrensi").prop('required', false);

        if ($('#get_sumber_loker_namaevent').val() != "" && $('#get_sumber_loker_namacareercenter').val() != "") {
            $.ajax({
                url: 'api/sumber-loker-ku/',
                type: type,
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (result) {
                    swal.fire("", "Berhasil Input data", "success");
                    $('#pengalamankerja').modal('show');
                },
                error: function () {
                    swal.fire("Oops..", "Gagal Input data", "error");
                }
            });
        } else {
            swal.fire("Opps..", "Kolom Bertanda ( * ) Merah Wajib Diisi", "error");
        }
    } else if ($("#get_sumber_loker_sumber").val() == "Referensi") {
        $(".get_sumber_loker_career_center").attr("disabled", true);
        $(".get_sumber_loker_sumber_lain").attr("disabled", true);
        $(".get_sumber_loker_refrensi").attr("disabled", false);

        $(".get_sumber_loker_career_center").prop('required', false);
        $(".get_sumber_loker_sumber_lain").prop('required', true);
        $(".get_sumber_loker_refrensi").prop('required', false);

        if ($('#get_sumber_loker_referrername').val() != "" && $('#get_sumber_loker_referrerphonenumber').val() != "" && $('#get_sumber_loker_referreremail').val() != "") {
            $.ajax({
                url: 'api/sumber-loker-ku/',
                type: type,
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (result) {
                    swal.fire("", "Berhasil Input data", "success");
                    $('#pengalamankerja').modal('show');
                },
                error: function () {
                    swal.fire("Opps..", "Gagal Input data", "error");
                }
            });
        }
        else {
            swal.fire("Opps..", "Kolom Bertanda ( * ) Merah Wajib Diisi", "error");
        }
    } else {
        $(".get_sumber_loker_career_center").attr("disabled", true);
        $(".get_sumber_loker_sumber_lain").attr("disabled", false);
        $(".get_sumber_loker_refrensi").attr("disabled", true);

        $(".get_sumber_loker_career_center").prop('required', false);
        $(".get_sumber_loker_sumber_lain").prop('required', false);
        $(".get_sumber_loker_refrensi").prop('required', true);

        if ($('#get_sumber_loker_sumberlain').val() != "") {
            $.ajax({
                url: 'api/sumber-loker-ku/',
                type: type,
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (result) {
                    swal.fire("", "Berhasil Input data", "success");
                    $('#pengalamankerja').modal('show');
                },
                error: function () {
                    swal.fire("Opps..", "Gagal Input data", "error");
                }
            });
        } else {
            swal.fire("Opps..", "Kolom Bertanda ( * ) Merah Wajib Diisi", "error");
        }
    }
})

    // Pengalaman Kerja & Sumber Lowongan Kerja
