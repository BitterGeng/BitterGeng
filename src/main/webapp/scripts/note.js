//删除笔记
function alertDeleteWindow() {
	$("#can").load("alert/alert_delete_note.html");
	$(".opacity_bg").show();
};

function sureDeleteNote() {
	$li = $("#note_ul a.checked").parent();
	var noteId = $li.data("cn_note_id");
	$.ajax({
		url : path + "/note/deleteNote.do",
		type : "POST",
		data : {
			"noteId" : noteId
		},
		dataType : "json",
		success : function(res) {
			closeAlertAddBook();
			if (res.status == 0) {
				alert("删除成功");
			} else {
				alert("删除失败");
			}
			$li.remove();

		},
		error : function() {
			alert("删除失败");
		}
	});
};

// 显示笔记的选项
function showNoteMenu() {
	$("#note_ul").on("click", ".btn_slide_down", function() {
		// 隐藏所有笔记菜单
		$("#note_ul div").hide();
		// 显示当前点击的菜单
		var note_menu = $(this).parents("li").find("div");
		note_menu.slideDown(1000);
		// 设置笔记li选中效果
		$("#note_ul a").removeClass("checked");
		$(this).parent().addClass("checked");
		// 阻止li和body的click事件冒泡
		return false;// 返回false就可以阻止冒泡
	});
	// 点击body范围,将笔记菜单隐藏
	$("body").click(function() {
		// 隐藏所有笔记菜单
		$("#note_ul div").hide();
	});
};

// 添加笔记本
function sureAddNote() {
	var title = $("#input_note").val().trim();
	// 获取这个笔记的bookId
	var userId = getCookie("userId");
	if (userId == null) {
		window.location.href = "log_in.html";
	}
	var $li = $("#book_ul a.checked").parent();
	var bookId = $li.data("cn_notebook_id");
	if (title == '') {
		alert("笔记标题不能为空");
	} else {
		$.ajax({
			url : path + "/note/addNote.do",
			type : "post",
			dataType : "json",
			data : {
				"bookId" : bookId,
				"title" : title,
				"userId" : userId
			},
			success : function(result) {
				closeAlertAddBook();
				var noteTitle = result.data.cn_note_title;
				var id = result.data.cn_note_id;
				createNoteLi(noteTitle, id);
				$("#input_note_title").val("");
				um.setContent("");
			},
			error : function() {
				alert("添加笔记失败");
			}
		});
	}
};

function closeAlertAddNote() {
	$("#can").html("");// 清空对话框内容
	$(".opacity_bg").hide();// 隐藏背景色
};

function AlertAddNote() {
	var $li = $("#book_ul a.checked").parent();
	if ($li.length == 0) {
		alert("请选择笔记本");
	} else {// 弹出对话框
		$("#can").load("alert/alert_note.html");
		$(".opacity_bg").show();
	}
};

// 保存笔记
function saveNote() {
	var body = um.getContent();
	var title = $("#input_note_title").val();
	var $li = $("#note_ul a.checked").parent();
	var noteId = $li.data("cn_note_id");// 笔记ID
	$.ajax({
		url : path + "/note/updateNote.do",
		type : "post",
		dataType : "json",
		data : {
			"noteId" : noteId,
			"body" : body,
			"title" : title
		},
		success : function(result) {
			if (result.status == 0) {
				alert("保存成功");
				var cn_note_body = result.data.cn_note_body;
				var cn_note_title = result.data.cn_note_title;
				$("#input_note_title").val(cn_note_title);
				um.setContent(cn_note_body);

			} else {
				alert("对不起更新失败了");
			}
		},
		error : function() {
			alert("更新笔记失败");
		}
	});
};

// 加载笔记内容
function loadNoteBody() {
	// 切换预览和编辑显示区域
	$("#pc_part_5").hide();// 预览区
	$("#pc_part_3").show();// 编辑区
	// 设置选中效果
	$("#note_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var noteId = $(this).data("cn_note_id");
	var ok = true;
	if (noteId == null) {
		ok = false;
	}
	if (ok) {
		$.ajax({
			url : path + "/note/loadNoteBody.do",
			type : "post",
			data : {
				"noteId" : noteId
			},
			dataType : "json",
			success : function(res) {
				if (res.status == 0) {
					var NoteTitle = res.data.cn_note_title;
					if (NoteTitle != null) {
						$("#input_note_title").val(NoteTitle);
					}
					var BodyContent = res.data.cn_note_body;
					if (BodyContent != null) {
						um.setContent(BodyContent);// 设置笔记内容
					}

				}
			},
			error : function() {
				alert("加载笔记内容失败");
			}
		});
	}
};

// 加载笔记列表
function loadNote() {
	$("#book_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var bookId = $(this).data("cn_notebook_id");
	var userId = getCookie("userId");
	var ok = false;
	if (userId != null) {
		ok = true;
	} else {
		window.location.href = "log_in.html";
	}
	if (ok) {

		$.ajax({
			url : path + "/book/loadNotes.do",
			data : {
				"bookId" : bookId
			},
			dataType : "json",
			type : "post",
			success : function(result) {
				if (result.status == 0) {
					$("#pc_part_2").show();
					$("#pc_part_4").hide();
					$("#pc_part_6").hide();
					$("#pc_part_7").hide();
					$("#pc_part_8").hide();
					var notes = result.data;
					// 每次进来前要把前面选中加载的笔记清除
					$("#note_ul").empty();
					for (var i = 0; i < notes.length; i++) {
						// 获取每一个笔记的noteId和noteName
						var cn_note_title = notes[i].cn_note_title;
						var cn_note_id = notes[i].cn_note_id
						createNoteLi(cn_note_title, cn_note_id);
					}

				}
			},
			error : function() {
				alert("加载笔记失败");
			}
		});
	}
};

function createNoteLi(cn_note_title, cn_note_id) {
	var sli = "";
	sli += '<li class="online">';
	sli += '  <a>';
	sli += '	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli += cn_note_title;
	sli += '	<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli += '  </a>';
	sli += '  <div class="note_menu" tabindex="-1">';
	sli += '	<dl>';
	sli += '		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	sli += '		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	sli += '		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli += '	</dl>';
	sli += '  </div>';
	sli += '</li>';
	// 将每一个li上面绑定一个noteId
	var $li = $(sli);
	$li.data("cn_note_id", cn_note_id);
	$("#note_ul").append($li);
};