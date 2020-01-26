$(() => {
	get_all_rencana();
	$('#page_sorting2').hide();
	$("#get_sent_date").attr("disabled", true);
});

function get_all_rencana() {
	$("#data_rows").html(
		`<tr> <td colspan="4" style="text-align:center"><i>Loading...</i> </td></td></tr>`
	);
	$.ajax({
		url: "api/rencana/paging?size=10&page=0",
		type: "get",
		contentType: "application/json",
		success: function (result) {
			$("#total-data").text(result.totalElements);
			$("#total-size").text(result.totalPages);
			$("#total-page").text(result.size);
			$("#total-ke").text(result.pageable.pageNumber);
			$("#count-page").val(result.pageable.pageNumber);
			$("#count-first").val(result.first);
			$("#count-last").val(result.last);

			var result = result.content;
			$("#data_rows").html("");
			var x;
			if (result.length > 0) {
				for (let i = 0; i < result.length; i++) {
					var y = result[i].automaticMail;
					if (y == true) {
						x = "Otomatis";
					} else {
						x = "Manual";
					}
					$("#data_rows").append(

						`	<tr>
								<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${result[i].scheduleCode}</div>
												<div class="col-sm"><h5>${result[i].scheduleDate}, ${result[i].time}</h5></div>
												
												<div class="col-sm">
													<p>RO      :${result[i].ro.biodataId.fullName} <br>
													TRO     : ${result[i].tro.biodataId.fullName}<br>
													Lokasi     : ${result[i].location} <br>
													Mode     : ${x} <br>
													Jenis Jadwal  : ${result[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${result[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${result[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_pelamarterjadwal(${result[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana_jadwal" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
												</div>
											</div>
								</td>
              </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4">
					<div class="alert alert-primary text-center" role="alert">
						Data tidak ditemukan! <span><i class="fa fa-error"></i></span>
					</div> 
					</td></tr>`
				);
			}
		},
		error: function () {
			swal("", "Failed to fetch data", "error");
		}
	});
};

//set tanggal dari
$(function () {
	$("#input-search-dari").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		minYear: 1980,
		maxYear: parseInt(moment().format("YYYY"), 10),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
});

//membatasi tanggal sampai
$("#input-search-dari").on("change", function () {
	var mindts = $("#input-search-dari").val();
	setmindate_kapan(mindts);
});

// set tanggal sampai
function setmindate_kapan(min) {
	$("#input-search-sampai").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		minDate: min,
		maxYear: parseInt(moment().format("YYYY"), 10),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
}

// set tanggal rencana
$(function () {
	$("#get_tgl_rencana").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		minYear: parseInt(moment().format("YYYY"), 10),
		minDate: moment(),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
});

// set tanggal rencana
$(function () {
	$("#get_sent_date").daterangepicker({
		autoUpdateInput: true,
		singleDatePicker: true,
		drops: "up",
		minYear: parseInt(moment().format("YYYY"), 10),
		minDate: moment(),
		locale: {
			format: "YYYY-MM-DD"
		}
	});
});

// set jam rencana
$(function () {
	$("#get_jam_rencana")
		.daterangepicker({
			timePicker: true,
			autoUpdateInput: true,
			singleDatePicker: true,
			timePicker24Hour: true,
			timePickerIncrement: 1,
			locale: {
				format: "HH:mm A"
			}
		})
		.on("show.daterangepicker", function (ev, picker) {
			picker.container.find(".calendar-table").hide();
		});
});

// menambah rencana
$("#add_rencana").click(function () {
	get_typeschedule();
	get_ro_isero_true();
	get_tro_isero_true();
	kode_rencana();
	$(".modal-judul").text("Buat Rencana Jadwal");
	$(".get_rencana").attr("disabled", false);
	$("#get_form_rencana")[0].reset();
	$("#get_id").val("");

	$("#action").val("tambah");
	$("#modal-rencana").modal("show");
});

//menghapus inputan
$("#btn-reset").on("click", function () {
	$("#input-search-dari, #input-search-sampai").val("");

	kode_rencana();
});

// fungsi menccari data
$("#btn-search").on("click", function () {
	$("#data_rows").html("");
	var tgl_mulai = $('#input-search-dari').val();
	var tgl_sampai = $('#input-search-sampai').val();

	if (tgl_mulai == '' || tgl_sampai == '') {
		swal.fire("Required", "Tanggal pencarian tidak boleh kosong, silahkan isi kembali.", "info");
	} else {
		search_data(tgl_mulai, tgl_sampai);
	}

});

// meyimpan hasil tambah dan edit data rencana
$("#save_rencana").click(function () {
	var action = $("#action").val();
	var boolCek = $("#cek_sent_date").val();
	var boolValue;
	if (boolCek == 'true') {
		boolValue = true;
	} else {
		boolValue = false;
	}
	// mengecek RO dan TRO
	var ro = $("#get_ro").val();
	var tro = $("#get_tro").val();
	var sch = $("#get_schedule_type").val();
	var schDate = $("#get_tgl_rencana").val();
	var schTime = $("#get_jam_rencana").val();

	var data = {
		id: $("#get_id").val(),
		scheduleTypeId: {
			id: $("#get_schedule_type").val()
		},
		ro: {
			id: $("#get_ro").val()
		},
		tro: {
			id: $("#get_tro").val()
		},
		scheduleCode: $("#get_schedule_code").val(),
		scheduleDate: $("#get_tgl_rencana").val(),
		time: $("#get_jam_rencana").val(),
		location: $("#get_lokasi").val(),
		otherRoTro: $("#get_othertro").val(),
		notes: $("#get_notes").val(),
		isAuto: boolValue,
		sentDate: $("#get_sent_date").val(),
	}

	if (action == "tambah") {
		type = "post";
	} else if (action == "ubah") {
		type = "put";
	}

	var emp1 = $('#e1').is(':checked');
	var emp2 = $('#e2').is(':checked');
	var emp3 = $('#e3').is(':checked');

	if (schDate == '') {
		Swal.fire(
			"",
			"Anda belum memilih Tanggal perencannaan.",
			"question"
		);
	} else if (schTime == '') {
		Swal.fire(
			"",
			"Anda belum mengisi waktu perencanaan.",
			"question"
		);
	} else if (ro == '') {
		Swal.fire(
			"",
			"Anda belum memilih nama Recruitment Officer.",
			"info"
		);
	} else if (tro == '') {
		Swal.fire(
			"",
			"Anda belum memilih nama Technical Recruitment Officer.",
			"info"
		);
	} else if (ro == tro) {
		Swal.fire(
			"",
			"Ro dan TRO tidak boleh memiliki jadwal yang sama.",
			"info"
		);
	} else if (sch == '') {
		Swal.fire(
			"",
			"Anda belum memilih jenis Schedule.",
			"info"
		);
	} else if (!emp1 && !emp2 && !emp3) {
		Swal.fire(
			"",
			"Anda belum memilih pelamar.",
			"info"
		);
	} else if ($('#cek_sent_date').is(':checked') && $('#get_sent_date').val() == '') {
		Swal.fire("", "Mohon pilih tanggal pengiriman terlebih dahulu", "warning");
	} else {
		if ($('#cek_sent_date').is(':checked')) {
			$.ajax({
				url: "/api/rencana",
				type: type,
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function (result) {
					get_all_rencana();
					Toast.fire({
						type: 'success',
						title: "Data berhasil di" + action + "."
					})
					$("#modal-rencana").modal("hide");
					$("#get_from_kirim_undangan")[0].reset();
				},
				error: function () {
					Swal.fire("", "Failed to " + action + " data", "error");
				}
			});
		} else {
			$.ajax({
				url: "/api/rencana",
				type: type,
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function (result) {
					get_all_rencana();
					Toast.fire({
						type: 'success',
						title: "Data berhasil di" + action + "."
					})
					$("#modal-rencana").modal("hide");
					kirim_data();
					$("#get_from_kirim_undangan")[0].reset();
				},
				error: function () {
					Swal.fire("", "Failed to " + action + " data", "error");
				}
			});
		}


	}
});


// function hapus rencana /jadwal
function hapus(id) {
	var data = {
		id: $("#get_id").val()
	};
	Swal.fire({
		title: "Are you sure?",
		text: "You won't be able to revert this!",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#3085d6",
		cancelButtonColor: "#d33",
		confirmButtonText: "Yes, delete it!"
	}).then(result => {
		if (result.value) {
			$.ajax({
				url: "/api/rencana/" + id,
				type: "delete",
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function (result) {
					get_all_rencana();
					Toast.fire({
						icon: 'success',
						title: 'Data berhasil dihapus.'
					})
				},
				error: function () {
					Toast.fire({
						icon: 'error',
						title: 'Data gagal dihapus'
					})
				}
			});
		}
	});
};

// get data by id rencana 
function get_data_byid(id, action) {

	$("#action").val(action);
	if (action == "detail") {
		$(".modal-judul").text("Detail Rencana");
		$(".get_rencana").attr("disabled", true);
		$(".x-hide").hide();
	} else {
		$(".modal-judul").text("Ubah Rencana");
		$(".get_rencana").attr("disabled", false);
		$(".x-hide").show();
	}

	$.ajax({
		url: "/api/rencana/" + id,
		type: "get",
		contentType: "application/json",
		success: function (rencana) {

			// $("#get_from_kirim_undangan")[0].reset();

			get_ro_isero_true(rencana.ro.biodataId.id);
			get_tro_isero_true(rencana.tro.biodataId.id);
			get_typeschedule(rencana.scheduleTypeId.id);
			$("#get_id").val(rencana.id);
			$("#get_schedule_code").val(rencana.scheduleCode);
			$("#get_tgl_rencana").val(rencana.scheduleDate);
			$("#get_jam_rencana").val(rencana.time);
			$("#get_lokasi").val(rencana.location);
			$("#get_othertro").val(rencana.otherRoTro);
			$("#get_notes").val(rencana.notes);
			$("#get_sent_date").val(rencana.sentDate)
			$("#is_auto").val(rencana.isAutomaticMail)
			$("#modal-rencana").modal("show");
		},
		error: function () {
			swal.fire("", "Failed to fetch the data", "error");
		}
	});
};

// ajax schedule
function get_typeschedule(scheduleId) {
	$.ajax({
		url: "api/schedule/",
		type: "get",
		contentType: "application/json",
		success: function (sch) {
			var optValue = "";
			optValue += '<option value="">- Pilih Jenis Jadwal -</option>';
			for (var i = 0; i < sch.length; i++) {
				if (scheduleId == sch[i].id) {
					optValue += `<option value="${sch[i].id}" selected="selected">${sch[i].name}</option>`;

				} else {
					optValue += `<option value="${sch[i].id}">${sch[i].name}</option>`;
				}
			}
			$("#get_schedule_type").html(optValue);
		},
		error: function () {
			swal("", "Gagal Mengambil Data", "error");
		}
	});
}

//ajax get RO dengan is_ero = true
function get_ro_isero_true(roId) {
	$.ajax({
		url: "api/employee/erotrue",
		type: "get",
		contentType: "application/json",
		success: function (ro) {
			var optValue = "";
			optValue += '<option value="">- Pilih Nama RO -</option>';
			for (var i = 0; i < ro.length; i++) {
				if (roId == ro[i].id) {
					optValue += `<option value="${ro[i].biodataId.id}" selected="selected">${ro[i].biodataId.fullName}</option>`;
				} else {
					optValue += `<option value="${ro[i].biodataId.id}">${ro[i].biodataId.fullName}</option>`;

				}
			}
			$("#get_ro").html(optValue);
		},
		error: function () {
			swal("", "Gagal Mengambil Data", "error");
		}
	});
}

//ajax get TRO dengan is_ero = true
function get_tro_isero_true(troId) {
	$.ajax({
		url: "api/employee/erotrue",
		type: "get",
		contentType: "application/json",
		success: function (tro) {
			var optValue = "";
			optValue += '<option value="">- Pilih Nama TRO -</option>';
			for (var i = 0; i < tro.length; i++) {
				if (troId == tro[i].id) {
					optValue += `<option value="${tro[i].biodataId.id}" selected="selected">${tro[i].biodataId.fullName}</option>`;
				} else {
					optValue += `<option value="${tro[i].biodataId.id}">${tro[i].biodataId.fullName}</option>`;
				}
			}
			$("#get_tro").html(optValue);
		},
		error: function () {
			swal("", "Gagal Mengambil Data", "error");
		}
	});
}

$('#cek_sent_date').click(function () {
	if ($('#cek_sent_date').is(':checked')) {
		$("#cek_sent_date").val('true')
		$("#get_sent_date").attr("disabled", false);
		$("#save_rencana").text("Simpan");
	} else {
		$("#save_rencana").text("Simpan & Kirim");
		$("#get_sent_date").val("");
		$("#get_sent_date").attr("disabled", true);
		$("#cek_sent_date").val('false')
	}
});

const Toast = Swal.mixin({
	toast: true,
	position: 'bottom-end',
	showConfirmButton: false,
	timer: 3000,
	// timerProgressBar: true,
	onOpen: (toast) => {
		toast.addEventListener('mouseenter', Swal.stopTimer)
		toast.addEventListener('mouseleave', Swal.resumeTimer)
	}
});

//Function search
function search_data(tgl_mulai, tgl_sampai) {
	$.ajax({
		url: "api/rencana/search?tgl_mulai=" + tgl_mulai + "&tgl_sampai=" + tgl_sampai,
		type: "get",
		contentType: "application/json",
		success: function (Data) {
			$("#data_rows").html("");
			var x;
			if (Data.length > 0) {
				for (let i = 0; i < Data.length; i++) {
					var y = Data[i].automaticMail;
					if (y == true) {
						x = "Otomatis";
					} else {
						x = "Manual";
					}
					$("#data_rows").append(

						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${Data[i].scheduleCode}</div>
												<div class="col-sm"><h5>${Data[i].scheduleDate}, ${Data[i].time}</h5></div>
												
												<div class="col-sm">
													<p class="">RO      :${Data[i].ro.biodataId.fullName}</p>
													<p class="">TRO     : ${Data[i].tro.biodataId.fullName}</p>
													<p class="">Location     : ${Data[i].location}</p>
													<p class ="">Mode: ${x} </p>
													<p class="">Jenis Jadwal  : ${Data[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${Data[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${Data[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${Data[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
												</div>

											</div>
											</td>
                       </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4">
					<div class="alert alert-primary text-center" role="alert">
						Data tidak ditemukan! <span><i class="fa fa-error"></i></span>
					</div> 
					</td></tr>`
				);
			}
		}
	});

}

$('#sort-data1').on('click', function () {
	var banyakdata = $("#show-info").text();
	paginate_data(0, banyakdata, 'id', 'asc');
	$('#page_sorting2').show();
	$('#page_sorting1').hide();
});

$('#sort-data2').on('click', function () {
	var banyakdata = $("#show-info").text();
	paginate_data(0, banyakdata, 'id', 'desc');
	$('#page_sorting1').show();
	$('#page_sorting2').hide();
});

// paginate data
function paginate_data(page, size, sortby, orderby) {
	$.ajax({
		url: "api/rencana/paging?page=" + page + "&size=" + size + "&sort=" + sortby + "," + orderby,
		type: 'get',
		contentType: 'application/json',
		success: function (pagination) {
			$("#total-data").text(pagination.totalElements);
			$("#total-page").text(pagination.size);
			$("#show-info").text(pagination.size);
			$("#total-size").text(pagination.totalPages);
			$("#total-ke").text(pagination.pageable.pageNumber);
			$("#count-page").val(pagination.pageable.pageNumber);
			$("#count-first").val(pagination.first);
			$("#count-last").val(pagination.last);

			var pagination = pagination.content;
			$("#data_rows").html("");
			var x;
			if (pagination.length > 0) {
				for (let i = 0; i < pagination.length; i++) {
					var y = pagination[i].automaticMail;
					if (y == true) {
						x = "Otomatis";
					} else {
						x = "Manual";
					}
					$("#data_rows").append(
						`
												<tr>
												<td>
											<div class="row font-weight-bold">
												<div class="col-sm">${pagination[i].scheduleCode}</div>
												<div class="col-sm"><h5>${pagination[i].scheduleDate}, ${pagination[i].time}</h5></div>
												
												<div class="col-sm">
													<p>RO      :${pagination[i].ro.biodataId.fullName} <br>
													TRO     : ${pagination[i].tro.biodataId.fullName}<br>
													Lokasi     : ${pagination[i].location} <br>
													Mode     : ${x} <br>
													Jenis Jadwal  : ${pagination[i].scheduleTypeId.name}</p>
												</div>
												
												<div class="col-sm">
												 <h5 class="">
                          <a onclick="get_data_byid(${pagination[i].id},'ubah')"  class="mr-2 " data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-edit" aria-hidden="true"></i></a>
                          <a onclick="hapus(${pagination[i].id})"  class="mr-2" data-toggle="modal" data-target="" href="#"
                              id="showAddData"><i class="fa fa-trash" aria-hidden="true"></i></a>
                          <a onclick="get_data_byid(${pagination[i].id},'detail')"  class="mr-2" data-toggle="modal" data-target="#modal-rencana" href="#"
                              id="showAddData"><i class="fa fa-search-plus" aria-hidden="true"></i></a>
                        </h5>
												</div>

											</div>
											</td>
                       </tr> 
											 `);
				}
			} else {
				$("#data_rows").html(
					`<tr> <td colspan="4">
					<div class="alert alert-primary text-center" role="alert">
						Data tidak ditemukan! <span><i class="fa fa-error"></i></span>
					</div> 
					</td></tr>`
				);
			}
		}
	});
};

// start menentukan banyak data perpage
$('#data-show-10').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 10, 'id', 'asc');
});

$('#data-show-20').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 20, 'id', 'asc');
});

$('#data-show-30').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 30, 'id', 'asc');
});

$('#data-show-40').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 40, 'id', 'asc');
});

$('#data-show-50').on('click', function () {
	$("#prev").attr('disabled', true);
	$("#next").attr('disabled', false);
	paginate_data(0, 50, 'id', 'asc');
});
//ending menentukan data perpage


//previous and next pabination
$('#prev').on('click', function () {
	var cekAwal = $("#count-first").val();
	var banyakdata = $("#show-info").text();
	var page = parseInt($('#count-page').val());

	if (cekAwal == "true") {
		$("#prev").attr("disabled", true);
		$("#next").attr("disabled", false);
	}

	if (page == 0) {
		page = 0;
	} else {
		page = page - 1;
	}
	paginate_data(page, banyakdata, 'id', 'asc');
	$("#count-first").val('');
	$("#count-last").val('false');
	$("#next").attr('disabled', false);
});

$('#next').on('click', function () {
	var cekAkhir = $("#count-last").val();
	var banyakdata = $("#show-info").text();
	var page = parseInt($('#count-page').val());

	if (cekAkhir == "true") {
		$("#next").attr("disabled", true);
		$("#prev").attr('disabled', false);
	}
	if (page >= 0) {
		page = page + 1;
		paginate_data(page, banyakdata, 'id', 'asc');
		$("#count-last").val('');
		$("#count-first").val('false');
		$("#prev").attr('disabled', false);
	}
});
// ending next dan previous function


//function mengirim ke email pelamar
function kirim_data() {
	var e1 = $('#e1').is(':checked');
	var e2 = $('#e2').is(':checked');
	var e3 = $('#e3').is(':checked');
	var plmr = '';

	if (e1 == true) {
		plmr = $('.e1').text();
	} else if (e2 == true) {
		plmr = $('.e2').text();
	} else if (e3 == true) {
		plmr = $('.e3').text();
	}

	var roff = $("#get_ro").val();
	var ro = '';
	if (roff == 1) {
		ro = 'Dwi Lisyanti, S.Pd';
	} else if (roff == 2) {
		ro = 'Alfia Husna, S.Si';
	} else if (roff == 3) {
		ro = 'Ario Bimo, S.Si'
	} else if (roff == 4) {
		ro = 'Muhammad Fathan'
	} else if (roff == 6) {
		ro = 'Eko Sutrisno, S.Pd'
	}

	var emp1 = $('#e1').is(':checked');
	var emp2 = $('#e2').is(':checked');
	var emp3 = $('#e3').is(':checked');
	var em = [];

	// penerima = 'debby.fudmasari@xsis.co.id';
	// penerima = 'imam.winata@xsis.co.id';
	// penerima = 'ariobimo74@gmail.com';


	if (emp1 == true && emp2 == false && emp3 == false) {
		em.push('ekosutrisno801@gmail.com');
		penerima = em.join();
	} else if (emp1 == false && emp2 == true && emp3 == false) {
		em.push('ekosutrisno801@yahoo.com');
		penerima = em.join();
	} else if (emp1 == false && emp2 == false && emp3 == true) {
		em.push('sutrisnoeko801@gmail.com');
		penerima = em.join();
	} else if (emp1 == true && emp2 == true && emp3 == false) {
		em.push('ekosutrisno801@gmail.com', 'ekosutrisno801@yahoo.com');
		penerima = em.join();
	} else if (emp1 == true && emp2 == false && emp3 == true) {
		em.push('ekosutrisno801@gmail.com', 'sutrisnoeko801@gmail.com');
		penerima = em.join();
	} else if (emp1 == false && emp2 == true && emp3 == true) {
		em.push('ekosutrisno801@yahoo.com', 'sutrisnoeko801@gmail.com');
		penerima = em.join();
	} else if (emp1 == true && emp2 == true && emp3 == true) {
		em.push('ekosutrisno801@gmail.com', 'ekosutrisno801@yahoo.com', 'sutrisnoeko801@gmail.com');
		penerima = em.join();
	}


	var judul = '';
	var namaro = $('#get_schedule_type').val();
	if (namaro == 1) {
		judul = 'Softskill';
	} else if (namaro == 2) {
		judul = 'Training';
	} else if (namaro == 3) {
		judul = 'Hiring';
	} else if (namaro == 4) {
		judul = 'Mini Project';
	} else if (namaro == 5) {
		judul = 'Filtering';
	} else if (namaro == 6) {
		judul = 'Kickoff Bootcamp';
	} else if (namaro == 7) {
		judul = 'Placement';
	} else if (namaro == 8) {
		judul = 'Interview';
	}

	// <strong>Nama<span> : </span>	 ` + nm + `</strong> <br>
	var nm = plmr;
	var tg = $("#get_tgl_rencana").val();
	var jm = $("#get_jam_rencana").val();
	var tm = $("#get_lokasi").val();
	var jd = judul;
	var ro = ro;
	var nt = $("#get_notes").val();

	var html = `
<!DOCTYPE html
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="format-detection" content="date=no" />
	<meta name="format-detection" content="address=no" />
	<meta name="format-detection" content="telephone=no" />
	<title>Email Template</title>


	<style type="text/css" media="screen">
		/* Linked Styles */
		body {
			padding: 0 !important;
			margin: 0 !important;
			display: block !important;
			min-width: 100% !important;
			width: 100% !important;
			background: #ffffff;
			-webkit-text-size-adjust: none
		}

		a {
			color: #4bb182;
			text-decoration: none
		}

		p {
			padding: 0 !important;
			margin: 0 !important
		}

		img {
			-ms-interpolation-mode: bicubic;
			/* Allow smoother rendering of resized image in Internet Explorer */
		}

		/* Mobile styles */
		@media only screen and (max-device-width: 480px),
		only screen and (max-width: 480px) {
			div[class='mobile-br-1'] {
				height: 1px !important;
			}

			div[class='mobile-br-1-b'] {
				height: 1px !important;
				background: #ffffff !important;
				display: block !important;
			}

			div[class='mobile-br-5'] {
				height: 5px !important;
			}

			div[class='mobile-br-10'] {
				height: 10px !important;
			}

			div[class='mobile-br-15'] {
				height: 15px !important;
			}

			div[class='mobile-br-20'] {
				height: 20px !important;
			}

			div[class='mobile-br-30'] {
				height: 30px !important;
			}

			th[class='m-td'],
			td[class='m-td'],
			div[class='hide-for-mobile'],
			span[class='hide-for-mobile'] {
				display: none !important;
				width: 0 !important;
				height: 0 !important;
				font-size: 0 !important;
				line-height: 0 !important;
				min-height: 0 !important;
			}

			span[class='mobile-block'] {
				display: block !important;
			}

			div[class='img-m-center'] {
				text-align: center !important;
			}

			div[class='h2-white-m-center'],
			div[class='text-white-m-center'],
			div[class='text-white-r-m-center'],
			div[class='h2-m-center'],
			div[class='text-m-center'],
			div[class='text-r-m-center'],
			td[class='text-top'],
			div[class='text-top'],
			div[class='h6-m-center'],
			div[class='text-m-center'],
			div[class='text-top-date'],
			div[class='text-white-top'],
			td[class='text-white-top'],
			td[class='text-white-top-r'],
			div[class='text-white-top-r'] {
				text-align: center !important;
			}

			div[class='fluid-img'] img,
			td[class='fluid-img'] img {
				width: 100% !important;
				max-width: 100% !important;
				height: auto !important;
			}

			table[class='mobile-shell'] {
				width: 100% !important;
				min-width: 100% !important;
			}

			table[class='center'] {
				margin: 0 auto;
			}

			th[class='column-rtl'],
			th[class='column-rtl2'],
			th[class='column-top'],
			th[class='column'] {
				float: left !important;
				width: 100% !important;
				display: block !important;
			}

			td[class='td'] {
				width: 100% !important;
				min-width: 100% !important;
			}

			td[class='content-spacing'] {
				width: 15px !important;
			}

			td[class='content-spacing2'] {
				width: 10px !important;
			}
		}
	</style>
</head>

<body class="body"
	style="padding:0 !important; margin:0 !important; display:block !important; min-width:100% !important; width:100% !important; background:#ffffff; -webkit-text-size-adjust:none">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
		<tr>
			<td align="center" valign="top">
				<!-- 3/ Header -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#4bb182">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
								style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
								<tr>
									<td height="20" class="spacer"
										style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;</td>
								</tr>
							</table>

							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
								style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
								<tr>
									<td height="20" class="spacer"
										style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;</td>
								</tr>
							</table>
						</td>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
					</tr>
				</table>
				<!-- END 3/ Header -->
				<!-- Section 4 -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#e6e6e6">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="650" border="0" cellspacing="0" cellpadding="0" class="mobile-shell">
								<tr>
									<td class="td"
										style="width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<!-- Head -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="50" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left"
																width="50"></td>
															<td>
																<div class="h3-grey-center"
																	style="color:#000000; font-family:Arial,sans-serif; font-size:26px; line-height:34px; text-align:center">
																	Jadwal ` + jd + `</div>
																<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
																	style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																	<tr>
																		<td height="22" class="spacer"
																			style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																			&nbsp;</td>
																	</tr>
																</table>

																<div class=""
																	style="color:#000000; font-family:Arial,sans-serif; font-size:14px; line-height:20px; text-align:left">
																	<p>Dear Kandidat, <br><br>
																	Berdasarkan berkas dan syarat lainnya yang telah anda kirimkan kepada kami, maka dari itu Kami
																	mengundangan Anda dalam agenda  ` + jd + ` yang akan dilaksanakan pada :<br>
																	<p><br>
																				<strong>Tanggal<span> : </span>	 ` + tg + `</strong><br>
																				<strong>Jam<span> : </span>	 ` + jm + `</strong><br>
																				<strong>Tempat<span> : </span>	 ` + tm + ` WIB</strong><br><br>
																				Atas perhatian dan kerjasamanya kami ucapkan terimaksaih.<br>
																				<strong>Notes<span> : </span>	</strong> ` + nt + `<br>
																	</p>
																</div>
																<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
																	style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																	<tr>
																		<td height="50" class="spacer"
																			style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																			&nbsp;</td>
																	</tr>
																</table>

															</td>
															<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left"
																width="50"></td>
														</tr>
													</table>
													<!-- END Head -->

													<!-- Articles -->
													<!-- row 1 -->
													<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
														<tr>
															<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left"
																width="10"></td>
															<td>
															</td>
														</tr>
													</table>

												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
					</tr>
				</table>
				<!-- END Section 4 -->

				<!-- Section 5 -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#4bb182">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="650" border="0" cellspacing="0" cellpadding="0" class="mobile-shell">
								<tr>
									<td class="td"
										style="width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0">
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
											style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
											<tr>
												<td height="50" class="spacer"
													style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;
												</td>
											</tr>
										</table>

										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="50">
												</td>
												<td>
													<div class="h3-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:26px; line-height:34px; text-align:center">
														What Our Clients Say About Us</div>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="22" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<div class="text-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:14px; line-height:20px; text-align:center">
														<em>"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
															mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus"</em></div>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="40" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="20" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<div class="h6-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:16px; line-height:22px; text-align:center; font-weight:bold">
														` + ro + `</div>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="6" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

													<div class="text-white-center"
														style="color:#ffffff; font-family:Arial,sans-serif; font-size:14px; line-height:20px; text-align:center">
														Recruitmen Officer</div>
												</td>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="50">
												</td>
											</tr>
										</table>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
											style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
											<tr>
												<td height="50" class="spacer"
													style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">&nbsp;
												</td>
											</tr>
										</table>

									</td>
								</tr>
							</table>
						</td>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
					</tr>
				</table>
				<!-- END Section 5 -->


				<!-- Footer -->
				<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#f9f9f9">
					<tr>
						<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="1"></td>
						<td align="center">
							<table width="650" border="0" cellspacing="0" cellpadding="0" class="mobile-shell">
								<tr>
									<td class="td"
										style="width:650px; min-width:650px; font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="30">
												</td>
												<td>
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<!-- Column -->
															<th class="column"
																style="font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; Margin:0"
																valign="bottom" width="266">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<td>
																			<div style="font-size:0pt; line-height:0pt;" class="mobile-br-20"></div>

																			<div class="text-m-center"
																				style="color:#777777; font-family:Arial,sans-serif; font-size:12px; line-height:20px; text-align:left">
																				<p>Copyright &copy; 2020 Xsis Academy</p>
																				</div>
																			<div style="font-size:0pt; line-height:0pt;" class="mobile-br-15"></div>

																		</td>
																	</tr>
																</table>
															</th>
															<!-- END Column -->
															<!-- Column -->
															<th class="column-top"
																style="font-size:0pt; line-height:0pt; padding:0; margin:0; font-weight:normal; vertical-align:top; Margin:0">
																<table width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<td>
																			<div class="text-r-m-center"
																				style="color:#777777; font-family:Arial,sans-serif; font-size:12px; line-height:24px; text-align:right">
																				<a href="#" target="_blank" class="link-grey2"
																					style="color:#666666; text-decoration:none"><span class="link-grey2"
																						style="color:#666666; text-decoration:none">Satrio Tower Lt. 25, Mega
																						Kuningan 9000</span></a>,Jakarta
																				<br />
																				<a href="www.xsis.academy" target="_blank" class="link-grey2-u"
																					style="color:#666666; text-decoration:underline"><span class="link-grey2-u"
																						style="color:#666666; text-decoration:underline">www.xsis.academy</span></a>
																				&nbsp; <a href="" target="_blank" class="link-grey2-u"
																					style="color:#666666; text-decoration:underline"><span class="link-grey2-u"
																						style="color:#666666; text-decoration:underline">xsisacademy@xsis.com</span></a>
																				<br />
																				Phone: <a href="tel:+1123456789" target="_blank" class="link-grey2"
																					style="color:#666666; text-decoration:none"><span class="link-grey2"
																						style="color:#666666; text-decoration:none">+1 (123) 456-789</span></a>
																			</div>
																		</td>
																	</tr>
																</table>
															</th>
															<!-- END Column -->
														</tr>
													</table>
													<table width="100%" border="0" cellspacing="0" cellpadding="0" class="spacer"
														style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
														<tr>
															<td height="40" class="spacer"
																style="font-size:0pt; line-height:0pt; text-align:center; width:100%; min-width:100%">
																&nbsp;</td>
														</tr>
													</table>

												</td>
												<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="30">
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
								<tr>
									<td class="content-spacing" style="font-size:0pt; line-height:0pt; text-align:left" width="30"></td>

								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- END Footer -->
			</td>
		</tr>
	</table>
</body>

</html>
`;


	var data = {
		penerima: penerima,
		judul: judul,
		konten: html
	}

	$.ajax({
		url: '/sendemail',
		type: 'post',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function () {
			Swal.fire("Sukses", "Email berhasil dikirim ke " + penerima, "success");
		},
		error: function () {
			Swal.fire("Gagal", "Email gagal dikirim ke " + penerima, "error");
		}
	})
};



// function generating code 
function kode_rencana() {
	var kode = 'JDW';
	$.ajax({
		url: "/api/rencana/desc",
		type: 'get',
		contentType: "application/json",
		success: function (result) {
			var data = result[0];
			var code = data.scheduleCode;

			if (code == '' || null) {
				code = kode + '0001';
			}

			code = code.substring(3, code.length)
			code = parseInt(code);

			var cek = String(code).length;
			var tambahan = '';
			if (cek == 1) {
				tambahan = '000'
			} else if (cek == 2) {
				tambahan = '00'
			} else if (cek == 3) {
				tambahan = '0'
			}

			code = kode + tambahan + (code + 1);
			console.log(code)
			$("#get_schedule_code").val(code)
		},
	});

}

function get_pelamarterjadwal(rencanaId) {
	$("#pelamar_terjadwal").html("")


	$.ajax({
		url: 'api/rencana-detail-ku/get/' + rencanaId,
		type: 'get',
		contentType: 'application/json',
		success: (res) => {
			// console.log(res)
			if (res.length == 0) {
				var a = 0;
				var no_data = "<tr><td colspan='3' style='text-align:center'><i>Data Tidak Ada</i></td></tr>";
				$("#pelamar_terjadwal").html(no_data)
			} else {
				a = 1
			}


			res.map((data) => {

				$.ajax({
					url: 'api/education-ku/name-last/' + data.biodataId.id,
					type: 'get',
					contentType: "application/json",
					success: function (result) {

						result.map((data2) => {


							if (a != 0) {
								var markup =
									"<tr>" +
									"<td>" + data.biodataId.fullName + "</td>" +
									"<td>" + data2.major + ', ' + data2.schoolName + "</td>" +
									"<td ><input id=\"get_modal_rencana\" type=\"hidden\" value=\"" + rencanaId + "\"></td>" +


									"<td>" +
									"<div class=\"btn-group\">" +
									"<button type=\"button\" class=\"btn btn-info\">Pilihan</button>" +
									"<button type=\"button\" class=\"btn btn-info dropdown-toggle\" data-toggle=\"dropdown\">" +
									"<span class=\"caret\"></span>" +
									"<span class=\"sr-only\">Toggle Dropdown</span>" +
									"</button>" +
									"<ul class=\"dropdown-menu\" role=\"menu\">" +
									"<li><a onclick=\"kirim_undangan('" + rencanaId + "','undang','" + data.biodataId.fullName + "','" + data.biodataId.email + "')\" >Undang</a></li>" +
									"<li><a onclick=\"ubah_rencana_jadwal('" + rencanaId + "','" + data.biodataId.id + "')\" >Ubah Jadwal</a></li>" +
									"</ul>" +
									"</div>" +
									"</td>" +
									"</tr>"
								$("#pelamar_terjadwal").append(markup)
							}
						})
					},
					error: function () {
						swal.fire("Opps..", "Fetch Last Education Failed", "error");
					}
				})
			})
		},
		error: () => {

			swal.fire("Opps..", "Fetch Biodata Failed", "error");
		}
	})
}

function kirim_undangan(rencanaId, action, nama, email) {

	$('#modal-kirim_undangan').modal('show');
	$('#modal-rencana_jadwal').modal('hide');

	$.ajax({
		url: 'api/rencana-jadwal-ku/' + rencanaId,
		type: 'get',
		contentType: 'application/json',
		success: (result) => {
			$("#modal_title_invite").html("");

			$("#get_jadwal_invite").html("");
			$("#get_ro_invite").html("");
			$("#get_lokasi_invite").html("");
			$("#get_tanggal_invite").html("");
			$("#get_tro_invite").html("");
			$("#get_other_invite").html("");



			$("#modal_title_invite").append("Kirim Undangan kepada ", nama);
			$("#get_jadwal_invite").append(result.scheduleTypeId.name);
			$("#get_ro_invite").append(result.ro.biodataId.nickName);
			$("#get_lokasi_invite").append(result.location);
			$("#get_tanggal_invite").append(result.scheduleDate);
			$("#get_tro_invite").append(result.tro.biodataId.nickName);
			$("#get_other_invite").append(result.otherRoTro);


			//get Value
			$("#get_rencana_id").val(result.id);
			$("#get_rencana_email").val(email);
			$("#get_nama").val(nama);
			$("#get_time").val(result.time);

			$("#get_jadwal_invite").val(result.scheduleTypeId.name);
			$("#get_ro_invite").val(result.ro.biodataId.nickName);
			$("#get_lokasi_invite").val(result.location);
			$("#get_tanggal_invite").val(result.scheduleDate);
			$("#get_tro_invite").val(result.tro.biodataId.nickName);
			$("#get_other_invite").val(result.otherRoTro);
			$("#get_catatan_invite").val(result.notes);


		}
	})
}

$(() => {
	get_disabled();
});
get_disabled = () => {
	$(document).ready(function () {
		$("input.checkbox_cek").on('change', function () {
			if ($('input.checkbox_cek').is(':checked')) {
				$('#get_ubah_sentdate').attr("disabled", false);
				$('#save_button_ubah').html("Simpan");


			} else {

				$('#get_ubah_sentdate').attr("disabled", true);
				$('#get_ubah_sentdate').val("");
				$('#save_button_ubah').html("Simpan & Kirim")




			}
		})
	})
}


function ubah_rencana_jadwal(rencanaId, biodataId) {

	$('#modal-ubah_rencana_jadwal').modal('show');
	$('#modal-rencana_jadwal').modal('hide');
	get_all_jenis();

	$.ajax({
		url: 'api/rencana-jadwal-ku/' + rencanaId,
		type: 'get',
		contentType: 'application/json',
		success: (result) => {
			var a = result.ro.biodataId.id;
			var b = result.tro.biodataId.id;

			// console.log(a)
			// console.log(b)

			get_ro(a);
			get_tro(b);

			$("#get_schedule_code").val(result.scheduleCode),


				$("#get_id_rencana").val(rencanaId),
				$("#get_id_biodata").val(biodataId),
				$("#get_rencana_id").val(result.id);
			$("#get_ubah_tanggal").val(result.scheduleDate);
			$("#get_ubah_jam").val(result.time);
			$("#get_ubah_ro").val(result.ro.biodataId.id);
			$("#get_ubah_tro").val(result.tro.biodataId.id);

			$("#get_ubah_scheduler").val(result.scheduleTypeId.id);
			$("#get_checkbox").val(result.isAutomaticMail);
			$("#get_ubah_lokasi").val(result.location);
			$("#get_ubah_other").val(result.otherRoTro);
			$("#get_ubah_sentdate").val(result.sentDate);
			$("#get_ubah_catatan").val(result.notes);

			if ($("#get_checkbox").val() == "true") {
				$('#get_checkbox').prop('checked', true);
				$('#save_button_ubah').html("Simpan");

			} else {
				$('#get_checkbox').prop('checked', false);
				$('#save_button_ubah').val("Simpan");
				$('#save_button_ubah').html("Simpan & Kirim");
			}

			if ($('input.checkbox_cek').is(':checked')) {
				$('#get_ubah_sentdate').prop("disabled", false);


			} else {


				$('#get_ubah_sentdate').prop("disabled", true);
				$('#get_ubah_sentdate').val("");
			}
		}

	})

}

$(".datepicker").datetimepicker({
	timepicker: false,
	datepicker: true,
	format: 'Y-m-d'
})


function get_tro(roIdtro) {

	$.ajax({

		url: 'api/employee-ku/',
		type: 'get',
		contentType: "application/json",
		success: function (result) {
			var optValue2 = "";
			optValue2 += '<option value="" disabled selected hidden>TRO</option>';
			for (var i = 0; i < result.length; i++) {
				if (roIdtro == result[i].id) {
					optValue2 += `<option value="${result[i].id}" selected="selected">${result[i].biodataId.nickName}</option>`;
				}
				else {
					optValue2 += `<option value="${result[i].id}">${result[i].biodataId.nickName}</option>`;
				}
			}
			$("#get_ubah_tro").html(optValue2);
		},
		error: function () {
			swal.fire("Opps..", "Gagal Mengambil Data", "error");
		}

	})
}


function get_ro(roIdro) {

	$.ajax({

		url: 'api/employee-ku/',
		type: 'get',
		contentType: "application/json",
		success: function (result) {
			var optValue1 = "";

			optValue1 += '<option value="" disabled selected hidden>RO</option>';

			for (var i = 0; i < result.length; i++) {

				if (roIdro == result[i].id) {

					optValue1 += `<option value="${result[i].id}" selected="selected" >${result[i].biodataId.nickName}</option>`;
				}
				else {
					optValue1 += `<option value="${result[i].id}">${result[i].biodataId.nickName}</option>`;

				}
			}
			$("#get_ubah_ro").html(optValue1);
		},
		error: function () {
			swal.fire("Opps..", "Gagal Mengambil Data", "error");
		}
	})
}
function get_all_jenis() {

	$.ajax({

		url: 'api/schedule-type-ku/',
		type: 'get',
		contentType: "application/json",
		success: function (result) {
			var optValue1 = "";

			optValue1 += '<option value="" disabled selected hidden>Jenis Jadwal *</option>';

			for (var i = 0; i < result.length; i++) {
				optValue1 += `<option value="${result[i].id}">${result[i].name}</option>`

			}
			$("#get_ubah_scheduler").html(optValue1);

		},
		error: function () {
			swal.fire("Opps..", "Gagal Mengambil Data", "error");
		}
	})
}



$('#save_button_ubah').click(function () {


	var rencanaId = $("#get_id_rencana").val();
	var biodataId = $("#get_id_biodata").val();
	var i = 0;



	if ($("#get_ubah_scheduler") == "" && $("#get_ubah_jam") == "" && $("#get_ubah_tanggal") == "") {
		swal.fire("Opps..", "Semua Mandatory Harus di Isi..!!", "error")
	} else {
		if ($('input.checkbox_cek').is(':checked')) {
			$("#get_checkbox").val(true)

		} else {
			$("#get_checkbox").val(false)
		}

		if ($("#get_ubah_ro").val() == $("#get_ubah_tro").val()) {
			swal.fire("Opps", "Data RO & TRO tidak boleh sama", "error");
		} else if ($("#get_ubah_tanggal").val() == "") {
			swal.fire("Opps", "Tanggal tidak boleh Kosong", "error");
		} else if ($("#get_ubah_scheduler").val() == "") {
			swal.fire("Opps", "Jenis Jadwal tidak Boleh Kosong", "error");
		} else {
			//isi	




			$.ajax({
				url: 'api/rencana-detail-ku/get/' + rencanaId + '/' + biodataId,
				type: 'get',
				contentType: 'application/json',
				success: (res) => {
					// swal.fire({
					// 	title: 'Please Wait..!',
					// 	text: 'Sending Email..',
					// 	icon: 'info',
					// 	allowOutsideClick: false,
					// 	allowEscapeKey: false,
					// 	allowEnterKey: false,
					// 	onOpen: () => {
					// 		swal.showLoading()
					// 	}
					// })

					var nama = res.biodataId.fullName;
					var jadwal = $("#get_ubah_scheduler").val();



					if (jadwal == res.rencanaJadwalId.scheduleTypeId.id) {
						var jadwal1 = res.rencanaJadwalId.scheduleTypeId.name;

					}


					var ro = $("#get_ubah_ro").val();

					if (ro == res.rencanaJadwalId.ro.biodataId.id) {
						var ro1 = res.rencanaJadwalId.ro.biodataId.fullName;

					}



					var lokasi = $("#get_ubah_lokasi").val();
					var tanggal_wawancara = $("#get_ubah_tanggal").val();
					var notes = $("#get_ubah_catatan").val();
					var email = res.biodataId.email;
					var waktu = $("#get_ubah_jam").val();


					if (nama == "" || nama == null) {
						nama = "-"
					} if (lokasi == "" || lokasi == null) {

						lokasi = "Coming Soon"
					} if (tanggal_wawancara == "" || tanggal_wawancara == null) {
						tanggal_wawancara = "Coming Soon"
					}
					if (notes == "" || notes == null) {
						notes = "-"
					}
					if (waktu == "" || waktu == null) {
						waktu == "-"
					}



					var sub =
						"Undangan Untuk " + jadwal + " di PT.Xsis Mitra Utama"
					var email_body = `
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional //EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:v="urn:schemas-microsoft-com:vml">

<head>
<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta content="width=device-width" name="viewport" />
<!--[if !mso]><!-->
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<!--<![endif]-->
<title></title>
<!--[if !mso]><!-->

<!--<![endif]-->
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

table,
td,
tr {
	vertical-align: top;
	border-collapse: collapse;
}

* {
	line-height: inherit;
}

a[x-apple-data-detectors=true] {
	color: inherit !important;
	text-decoration: none !important;
}
</style>
<style id="media-query" type="text/css">
@media (max-width: 660px) {

	.block-grid,
	.col {
		min-width: 320px !important;
		max-width: 100% !important;
		display: block !important;
	}

	.block-grid {
		width: 100% !important;
	}

	.col {
		width: 100% !important;
	}

	.col>div {
		margin: 0 auto;
	}

	img.fullwidth,
	img.fullwidthOnMobile {
		max-width: 100% !important;
	}

	.no-stack .col {
		min-width: 0 !important;
		display: table-cell !important;
	}

	.no-stack.two-up .col {
		width: 50% !important;
	}

	.no-stack .col.num4 {
		width: 33% !important;
	}

	.no-stack .col.num8 {
		width: 66% !important;
	}

	.no-stack .col.num4 {
		width: 33% !important;
	}

	.no-stack .col.num3 {
		width: 25% !important;
	}

	.no-stack .col.num6 {
		width: 50% !important;
	}

	.no-stack .col.num9 {
		width: 75% !important;
	}

	.video-block {
		max-width: none !important;
	}

	.mobile_hide {
		min-height: 0px;
		max-height: 0px;
		max-width: 0px;
		display: none;
		overflow: hidden;
		font-size: 0px;
	}

	.desktop_hide {
		display: block !important;
		max-height: none !important;
	}
}
</style>
</head>

<body class="clean-body" style="margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;">
<!--[if IE]><div class="ie-browser"><![endif]-->
<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0" class="nl-container" role="presentation"
style="table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;"
valign="top" width="100%">
<tbody>
	<tr style="vertical-align: top;" valign="top">
		<td style="word-break: break-word; vertical-align: top;" valign="top">
			<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td align="center" style="background-color:#FFFFFF"><![endif]-->
			<div style="background-color:transparent;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;">
					<div style="border-collapse: collapse;display: table;width: 100%;background-color:transparent;">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:transparent;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:transparent"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:20px; padding-bottom:15px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:20px; padding-bottom:15px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<div style="background-color:#E7ECEF;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;">
					<div style="border-collapse: collapse;display: table;width: 100%;background-color:transparent;">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:#E7ECEF;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:transparent"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="30" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="30"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px; font-family: Georgia, serif"><![endif]-->
									<div
										style="color:#555555;font-family:Bitter, Georgia, Times, Times New Roman, serif;line-height:1.2;padding-top:10px;padding-right:20px;padding-bottom:10px;padding-left:20px;">
										
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 20px; font-family: Arial, sans-serif"><![endif]-->
									<div
										style="color:#4E5264;font-family:'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:20px;padding-left:10px;">
										<div
											style="font-size: 14px; line-height: 1.5; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #4E5264; mso-line-height-alt: 21px;">
											<p
												style="font-size: 16px; line-height: 1.5; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;">Dear, `+ nama + `</span></p>
												<br>
												
											<p
												style="font-size: 16px; line-height: 1.5;  font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;">Kami dari <strong>PT. Xsis Mitra Utama</strong> mengundang anda dalam <strong>`+ jadwal1 + `</strong> yang akan diadakan pada tanggal :
													<br><br><strong>Tanggal :</strong> `+ tanggal_wawancara + `
													<br><strong>Lokasi</strong> : `+ lokasi + ` 
													<br><strong>Waktu</strong> : `+ waktu + ` WIB

													<br><br>Demikian Pemanggilan Wawancara ini Kami harap saudara/i datang 15 menit lebih awal dari jadwal yang sudah di tetapkan
													</span></p>
													<br>
											<p
												style="font-size: 16px; line-height: 1.5; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;"><strong>*Notes : </strong>`+ notes + `</span></p>
												<br>
												
												
										</div>
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="35" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 35px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="35"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<div style="background-color:#0F7173;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #0F7173;">
					<div
						style="border-collapse: collapse;display: table;width: 100%;background-color:#0F7173;background-image:url('images/footer-bg.png');background-position:top center;background-repeat:no-repeat">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:#0F7173;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:#0F7173"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:#0F7173;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="15" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 15px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="15"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 15px; font-family: Arial, sans-serif"><![endif]-->
									<div
										style="color:#4E5264;font-family:'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:15px;padding-left:10px;">
										<div
											style="font-size: 14px; line-height: 1.5; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #4E5264; mso-line-height-alt: 21px;">
											<p
												style="font-size: 16px; line-height: 1.5; text-align: center; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #b9d6d6;">Terimakasih Atas Perhatiannya.
													<br>Salam,
													<br>`+ ro1 + `
													<br>PT. Xsis Mitra Utama</span></p>

											<p
											
												style="font-size: 16px; line-height: 1.5; text-align: center; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #b9d6d6;">
											<br>
											<br>© Xsis Mitra Utama
													Copyright 2020</span></p>
										</div>
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="10" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 10px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="10"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
		</td>
	</tr>
</tbody>
</table>
<!--[if (IE)]></div><![endif]-->
</body>

</html>`;


					var data = {
						to: email,
						subject: sub,
						text: email_body,

					}
					$.ajax({
						url: 'api/rencana-jadwal-ku/send',
						type: 'post',
						contentType: 'application/json',
						data: JSON.stringify(data),
						success: function (result) {

						}, error: function (e) {
							if (e.responseText == "Email sent Successfully") {
								swal.hideLoading()
								swal.fire({
									title: 'Success',
									text: 'Edit and Sending Email Success',
									icon: 'success',
								})
								loadData();


								var data = {
									id: $("#get_rencana_id").val(),
									scheduleCode: $("#get_schedule_code").val(),
									scheduleDate: $("#get_ubah_tanggal").val(),
									time: $("#get_ubah_jam").val(),
									ro: {
										id: $("#get_ubah_ro").val(),
									},
									tro: {
										id: $("#get_ubah_tro").val(),
									},
									scheduleTypeId: {
										id: $("#get_ubah_scheduler").val(),
									},
									location: $("#get_ubah_lokasi").val(),
									otherRoTro: $("#get_ubah_other").val(),
									notes: $("#get_ubah_catatan").val(),
									isAutomaticMail: $("#get_checkbox").val(),
									sentDate: $("#get_ubah_sentdate").val(),
								}



								$.ajax({
									url: 'api/rencana-jadwal-ku/',
									type: 'put',
									contentType: 'application/json',
									data: JSON.stringify(data),
									success: function (result) {
										// swal.fire("","Berhasil Mengubah data", "success");										
										$('#modal-ubah_rencana_jadwal').modal('hide');
										$('#modal-rencana_jadwal').modal('show');
										$('#modal-kirim_undangan').modal('hide');
										// loadData();
										if ($("#get_checkbox").val() == "false") {


										}
									}, error: function () {
										swal.fire("Opps..", "Gagal ubah Data", "error")
									}

								})


							} else {
								swal.fire({
									title: 'Opps...',
									text: e.responseText + ', Try Again',
									icon: 'error',
								});
								$('#modal-ubah_rencana_jadwal').modal('hide');
								$('#modal-rencana_jadwal').modal('show');
								$('#modal-kirim_undangan').modal('hide');
							}
						}

					})


				},
				error: () => {

					swal.fire("Opps..", "Fetch Biodata Failed", "error");
				}
			});
		}


	}
})


$('#save_button_all').click(function () {
	var rencanaId = $("#get_modal_rencana").val();
	var i = 1;

	if (rencanaId == undefined) {
		swal.fire("Opps..", "Isi data terlebih dahulu", "error")
	} else {
		$.ajax({
			url: 'api/rencana-detail-ku/get/' + rencanaId,
			type: 'get',
			contentType: 'application/json',
			success: (res) => {
				res.map((data) => {
					swal.fire({
						title: 'Please Wait..!',
						text: 'Sending All Email..',
						icon: 'info',
						allowOutsideClick: false,
						allowEscapeKey: false,
						allowEnterKey: false,
						onOpen: () => {
							swal.showLoading()
						}
					})

					var nama = data.biodataId.fullName;
					var jadwal = data.rencanaJadwalId.scheduleTypeId.name;
					var ro = data.rencanaJadwalId.ro.biodataId.fullName;
					var lokasi = data.rencanaJadwalId.location;
					var tanggal_wawancara = data.rencanaJadwalId.scheduleDate;
					var notes = data.rencanaJadwalId.notes;
					var email = data.biodataId.email;
					var waktu = data.rencanaJadwalId.time;

					if (nama == "" || nama == null) {
						nama = "-"
					} if (lokasi == "" || lokasi == null) {
						lokasi = "Coming Soon"
					} if (tanggal_wawancara == "" || tanggal_wawancara == null) {
						tanggal_wawancara = "Coming Soon"
					}
					if (notes == "" || notes == null) {
						notes = "-"
					}
					if (waktu == "" || waktu == null) {
						waktu == "-"
					}



					var sub =
						"Undangan Untuk " + jadwal + " di PT.Xsis Mitra Utama"
					var email_body =
						`
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional //EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:v="urn:schemas-microsoft-com:vml">

<head>
<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta content="width=device-width" name="viewport" />
<!--[if !mso]><!-->
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<!--<![endif]-->
<title></title>
<!--[if !mso]><!-->

<!--<![endif]-->
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

table,
td,
tr {
	vertical-align: top;
	border-collapse: collapse;
}

* {
	line-height: inherit;
}

a[x-apple-data-detectors=true] {
	color: inherit !important;
	text-decoration: none !important;
}
</style>
<style id="media-query" type="text/css">
@media (max-width: 660px) {

	.block-grid,
	.col {
		min-width: 320px !important;
		max-width: 100% !important;
		display: block !important;
	}

	.block-grid {
		width: 100% !important;
	}

	.col {
		width: 100% !important;
	}

	.col>div {
		margin: 0 auto;
	}

	img.fullwidth,
	img.fullwidthOnMobile {
		max-width: 100% !important;
	}

	.no-stack .col {
		min-width: 0 !important;
		display: table-cell !important;
	}

	.no-stack.two-up .col {
		width: 50% !important;
	}

	.no-stack .col.num4 {
		width: 33% !important;
	}

	.no-stack .col.num8 {
		width: 66% !important;
	}

	.no-stack .col.num4 {
		width: 33% !important;
	}

	.no-stack .col.num3 {
		width: 25% !important;
	}

	.no-stack .col.num6 {
		width: 50% !important;
	}

	.no-stack .col.num9 {
		width: 75% !important;
	}

	.video-block {
		max-width: none !important;
	}

	.mobile_hide {
		min-height: 0px;
		max-height: 0px;
		max-width: 0px;
		display: none;
		overflow: hidden;
		font-size: 0px;
	}

	.desktop_hide {
		display: block !important;
		max-height: none !important;
	}
}
</style>
</head>

<body class="clean-body" style="margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;">
<!--[if IE]><div class="ie-browser"><![endif]-->
<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0" class="nl-container" role="presentation"
style="table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;"
valign="top" width="100%">
<tbody>
	<tr style="vertical-align: top;" valign="top">
		<td style="word-break: break-word; vertical-align: top;" valign="top">
			<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td align="center" style="background-color:#FFFFFF"><![endif]-->
			<div style="background-color:transparent;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;">
					<div style="border-collapse: collapse;display: table;width: 100%;background-color:transparent;">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:transparent;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:transparent"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:20px; padding-bottom:15px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:20px; padding-bottom:15px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<div style="background-color:#E7ECEF;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;">
					<div style="border-collapse: collapse;display: table;width: 100%;background-color:transparent;">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:#E7ECEF;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:transparent"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="30" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="30"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px; font-family: Georgia, serif"><![endif]-->
									<div
										style="color:#555555;font-family:Bitter, Georgia, Times, Times New Roman, serif;line-height:1.2;padding-top:10px;padding-right:20px;padding-bottom:10px;padding-left:20px;">
										
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 20px; font-family: Arial, sans-serif"><![endif]-->
									<div
										style="color:#4E5264;font-family:'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:20px;padding-left:10px;">
										<div
											style="font-size: 14px; line-height: 1.5; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #4E5264; mso-line-height-alt: 21px;">
											<p
												style="font-size: 16px; line-height: 1.5; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;">Dear, `+ nama + `</span></p>
												<br>
												
											<p
												style="font-size: 16px; line-height: 1.5;  font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;">Kami dari <strong>PT. Xsis Mitra Utama</strong> mengundang anda dalam <strong>`+ jadwal + `</strong> yang akan diadakan pada tanggal :
													<br><br><strong>Tanggal :</strong> `+ tanggal_wawancara + `
													<br><strong>Lokasi</strong> : `+ lokasi + ` 
													<br><strong>Waktu</strong> : `+ waktu + ` WIB

													<br><br>Demikian Pemanggilan Wawancara ini Kami harap saudara/i datang 15 menit lebih awal dari jadwal yang sudah di tetapkan
													</span></p>
													<br>
											<p
												style="font-size: 16px; line-height: 1.5; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;"><strong>*Notes : </strong>`+ notes + `</span></p>
												<br>
												
												
										</div>
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="35" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 35px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="35"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<div style="background-color:#0F7173;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #0F7173;">
					<div
						style="border-collapse: collapse;display: table;width: 100%;background-color:#0F7173;background-image:url('images/footer-bg.png');background-position:top center;background-repeat:no-repeat">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:#0F7173;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:#0F7173"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:#0F7173;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="15" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 15px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="15"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 15px; font-family: Arial, sans-serif"><![endif]-->
									<div
										style="color:#4E5264;font-family:'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:15px;padding-left:10px;">
										<div
											style="font-size: 14px; line-height: 1.5; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #4E5264; mso-line-height-alt: 21px;">
											<p
												style="font-size: 16px; line-height: 1.5; text-align: center; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #b9d6d6;">Terimakasih Atas Perhatiannya.
													<br>Salam,
													<br>`+ ro + `
													<br>PT. Xsis Mitra Utama</span></p>

											<p
											
												style="font-size: 16px; line-height: 1.5; text-align: center; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #b9d6d6;">
											<br>
											<br>© Xsis Mitra Utama
													Copyright 2020</span></p>
										</div>
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="10" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 10px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="10"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
		</td>
	</tr>
</tbody>
</table>
<!--[if (IE)]></div><![endif]-->
</body>

</html>`;

					var data = {
						to: email,
						subject: sub,
						text: email_body,

					}


					$.ajax({
						url: 'api/rencana-jadwal-ku/send',
						type: 'post',
						contentType: 'application/json',
						data: JSON.stringify(data),
						success: function (result) {
						}, error: function (e) {
							console.log(e.responseText)
							if (e.responseText == "Email sent Successfully") {
								if (i == res.length) {
									swal.hideLoading()
									swal.fire({
										title: 'Success',
										text: 'All Email has been Sended',
										icon: 'success',

									})

									$('#modal-rencana_jadwal').modal('show');
									$('#modal-kirim_undangan').modal('hide');
								}
								i = i + 1;

							} else {
								swal.hideLoading()
								swal.fire({
									title: 'Opps...',
									text: e.responseText + 'Try Again',
									icon: 'error',
								});

							}


						}

					})

				})
			},
			error: () => {

				swal.fire("Opps..", "Send Email Failed", "error");
			}

		})

	}

})


$('#save_button').click(function () {


	var nama = $("#get_nama").val();
	var jadwal = $("#get_jadwal_invite").val();
	var ro = $("#get_ro_invite").val();
	var lokasi = $("#get_lokasi_invite").val();
	var tanggal_wawancara = $("#get_tanggal_invite").val();
	var notes = $("#get_catatan_invite").val();
	var email = $("#get_rencana_email").val();
	var waktu = $("#get_time").val();



	if (nama == "" || nama == null) {
		nama = "-"
	} if (lokasi == "" || lokasi == null) {

		lokasi = "Coming Soon"
	} if (tanggal_wawancara == "" || tanggal_wawancara == null) {
		tanggal_wawancara = "Coming Soon"

	}
	if (notes == "" || notes == null) {
		notes = ""
	} if (waktu == "" || waktu == null) {
		waktu == "-"
	}

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


	var sub =
		"Undangan Untuk " + jadwal + " di PT.Xsis Mitra Utama"
	var email_body =
		`
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional //EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:v="urn:schemas-microsoft-com:vml">

<head>
<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta content="width=device-width" name="viewport" />
<!--[if !mso]><!-->
<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<!--<![endif]-->
<title></title>
<!--[if !mso]><!-->

<!--<![endif]-->
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

table,
td,
tr {
	vertical-align: top;
	border-collapse: collapse;
}

* {
	line-height: inherit;
}

a[x-apple-data-detectors=true] {
	color: inherit !important;
	text-decoration: none !important;
}
</style>
<style id="media-query" type="text/css">
@media (max-width: 660px) {

	.block-grid,
	.col {
		min-width: 320px !important;
		max-width: 100% !important;
		display: block !important;
	}

	.block-grid {
		width: 100% !important;
	}

	.col {
		width: 100% !important;
	}

	.col>div {
		margin: 0 auto;
	}

	img.fullwidth,
	img.fullwidthOnMobile {
		max-width: 100% !important;
	}

	.no-stack .col {
		min-width: 0 !important;
		display: table-cell !important;
	}

	.no-stack.two-up .col {
		width: 50% !important;
	}

	.no-stack .col.num4 {
		width: 33% !important;
	}

	.no-stack .col.num8 {
		width: 66% !important;
	}

	.no-stack .col.num4 {
		width: 33% !important;
	}

	.no-stack .col.num3 {
		width: 25% !important;
	}

	.no-stack .col.num6 {
		width: 50% !important;
	}

	.no-stack .col.num9 {
		width: 75% !important;
	}

	.video-block {
		max-width: none !important;
	}

	.mobile_hide {
		min-height: 0px;
		max-height: 0px;
		max-width: 0px;
		display: none;
		overflow: hidden;
		font-size: 0px;
	}

	.desktop_hide {
		display: block !important;
		max-height: none !important;
	}
}
</style>
</head>

<body class="clean-body" style="margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;">
<!--[if IE]><div class="ie-browser"><![endif]-->
<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0" class="nl-container" role="presentation"
style="table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;"
valign="top" width="100%">
<tbody>
	<tr style="vertical-align: top;" valign="top">
		<td style="word-break: break-word; vertical-align: top;" valign="top">
			<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td align="center" style="background-color:#FFFFFF"><![endif]-->
			<div style="background-color:transparent;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;">
					<div style="border-collapse: collapse;display: table;width: 100%;background-color:transparent;">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:transparent;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:transparent"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:20px; padding-bottom:15px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:20px; padding-bottom:15px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<div style="background-color:#E7ECEF;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;">
					<div style="border-collapse: collapse;display: table;width: 100%;background-color:transparent;">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:#E7ECEF;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:transparent"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:transparent;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="30" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="30"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 20px; padding-left: 20px; padding-top: 10px; padding-bottom: 10px; font-family: Georgia, serif"><![endif]-->
									<div
										style="color:#555555;font-family:Bitter, Georgia, Times, Times New Roman, serif;line-height:1.2;padding-top:10px;padding-right:20px;padding-bottom:10px;padding-left:20px;">
										
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 20px; font-family: Arial, sans-serif"><![endif]-->
									<div
										style="color:#4E5264;font-family:'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:20px;padding-left:10px;">
										<div
											style="font-size: 14px; line-height: 1.5; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #4E5264; mso-line-height-alt: 21px;">
											<p
												style="font-size: 16px; line-height: 1.5; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;">Dear, `+ nama + `</span></p>
												<br>
												
											<p
												style="font-size: 16px; line-height: 1.5;  font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;">Kami dari <strong>PT. Xsis Mitra Utama</strong> mengundang anda dalam <strong>`+ jadwal + `</strong> yang akan diadakan pada tanggal :
													<br><br><strong>Tanggal :</strong> `+ tanggal_wawancara + `
													<br><strong>Lokasi</strong> : `+ lokasi + ` 
													<br><strong>Waktu</strong> : `+ waktu + ` WIB

													<br><br>Demikian Pemanggilan Wawancara ini Kami harap saudara/i datang 15 menit lebih awal dari jadwal yang sudah di tetapkan
													</span></p>
													<br>
											<p
												style="font-size: 16px; line-height: 1.5; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #4e5264;"><strong>*Notes : </strong>`+ notes + `</span></p>
												<br>
												
												
										</div>
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="35" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 35px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="35"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<div style="background-color:#0F7173;">
				<div class="block-grid"
					style="Margin: 0 auto; min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: #0F7173;">
					<div
						style="border-collapse: collapse;display: table;width: 100%;background-color:#0F7173;background-image:url('images/footer-bg.png');background-position:top center;background-repeat:no-repeat">
						<!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0" style="background-color:#0F7173;"><tr><td align="center"><table cellpadding="0" cellspacing="0" border="0" style="width:640px"><tr class="layout-full-width" style="background-color:#0F7173"><![endif]-->
						<!--[if (mso)|(IE)]><td align="center" width="640" style="background-color:#0F7173;width:640px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;" valign="top"><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;"><![endif]-->
						<div class="col num12"
							style="min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;">
							<div style="width:100% !important;">
								<!--[if (!mso)&(!IE)]><!-->
								<div
									style="border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;">
									<!--<![endif]-->
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="15" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 15px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="15"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									
									<!--[if mso]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td style="padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 15px; font-family: Arial, sans-serif"><![endif]-->
									<div
										style="color:#4E5264;font-family:'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.5;padding-top:10px;padding-right:10px;padding-bottom:15px;padding-left:10px;">
										<div
											style="font-size: 14px; line-height: 1.5; font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #4E5264; mso-line-height-alt: 21px;">
											<p
												style="font-size: 16px; line-height: 1.5; text-align: center; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #b9d6d6;">Terimakasih Atas Perhatiannya.
													<br>Salam,
													<br>`+ ro + `
													<br>PT. Xsis Mitra Utama</span></p>

											<p
											
												style="font-size: 16px; line-height: 1.5; text-align: center; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; word-break: break-word; mso-line-height-alt: 24px; margin: 0;">
												<span style="font-size: 16px; color: #b9d6d6;">
											<br>
											<br>© Xsis Mitra Utama
													Copyright 2020</span></p>
										</div>
									</div>
									<!--[if mso]></td></tr></table><![endif]-->
									
									<table border="0" cellpadding="0" cellspacing="0" class="divider" role="presentation"
										style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
										valign="top" width="100%">
										<tbody>
											<tr style="vertical-align: top;" valign="top">
												<td class="divider_inner"
													style="word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 0px; padding-bottom: 10px; padding-left: 0px;"
													valign="top">
													<table align="center" border="0" cellpadding="0" cellspacing="0" class="divider_content"
														height="10" role="presentation"
														style="table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 10px; width: 100%;"
														valign="top" width="100%">
														<tbody>
															<tr style="vertical-align: top;" valign="top">
																<td height="10"
																	style="word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;"
																	valign="top"><span></span></td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
									<!--[if (!mso)&(!IE)]><!-->
								</div>
								<!--<![endif]-->
							</div>
						</div>
						<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
						<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->
					</div>
				</div>
			</div>
			<!--[if (mso)|(IE)]></td></tr></table><![endif]-->
		</td>
	</tr>
</tbody>
</table>
<!--[if (IE)]></div><![endif]-->
</body>

</html>`;

	var data = {
		to: email,
		subject: sub,
		text: email_body,

	}


	$.ajax({
		url: 'api/rencana-jadwal-ku/send',
		type: 'post',
		contentType: 'application/json',
		data: JSON.stringify(data),
		success: function (result) {


		}, error: function (e) {
			if (e.responseText = "Email sent Successfully") {
				swal.hideLoading()
				swal.fire({
					title: 'Success',
					text: 'Email has been Sended',
					icon: 'success',
				});
				$('#modal-rencana_jadwal').modal('show');
				$('#modal-kirim_undangan').modal('hide');

			} else {
				swal.hideLoading()
				swal.fire({
					title: 'Opps...',
					text: 'Error Sending Email, Try Again',
					icon: 'error',
				});
			}
		}


	})
})

