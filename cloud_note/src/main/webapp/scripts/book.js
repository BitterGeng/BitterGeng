//删除笔记本
function alertDeleteBook() {
	$("#can").load("alert/alert_delete_notebook.html");
	$(".opacity_bg").show();
};

function sureDeleteBook() {
	var $li = $("#book_ul a.checked").parent();
	if ($li.length == 0) {
		alert("请选择要删除的笔记本");
	}
	var userId = getCookie("userId");
	var ok = true;
	if (userId == null) {
		ok = false;
		window.location.href = "log_in.html";
	}
	var bookId = $li.data("cn_notebook_id");
	if (ok && bookId != null) {
		$.ajax({
			url : path + "/book/deleteBook.do",
			type : "post",
			data : {
				"bookId" : bookId
			},
			dataType : "json",
			success : function(res) {
				if (res.status == 0) {
					$li.remove();
					closeAlertAddBook();
				} else {
					alert("删除失败");
				}
			},
			error : function() {
				alert("删除失败");
			}
		});
	}
};

// 添加笔记本
function AlertAddBook() {
	$("#can").load("alert/alert_notebook.html");
	$(".opacity_bg").show();
};

function closeAlertAddBook() {
	$("#can").html("");// 清空对话框内容
	$(".opacity_bg").hide();// 隐藏背景色
};
function sure_addbook() {
	// 获取创建笔记本的名字
	var bookName = $("#input_notebook").val().trim();
	var ok = true;
	if (input_notebook == null) {
		$("#name_span").html("笔记本名为空");
		ok = false;
	}
	var userId = getCookie("userId");
	if (userId == null) {
		window.location.href = "log_in.html";
		ok = false;
	}
	if (ok) {
		$.ajax({
			url : path + "/book/addBook.do",
			type : "post",
			data : {
				"bookName" : bookName,
				"userId" : userId
			},
			dataType : "json",
			success : function(result) {
				// alert("添加笔记本成功");
				if (result.status == 0) {
					alert(result.msg);
					window.location.href = "edit.html";
				}
			},
			error : function() {
				alert("添加笔记本失败");
			}
		});
	}
};

// 加载笔记本
function loadBooks() {
	var userId = getCookie("userId");
	if (userId == null) {
		window.location.href = "log_in.html";
	} else {
		// 发送ajax请求
		$.ajax({
			url : path + "/book/loadBook.do",
			type : "post",
			data : {
				"userId" : userId
			},
			dataType : "json",
			success : function(result) {
				var books = result.data;
				for (var i = 0; i < books.length; i++) {
					var cn_notebook_id = books[i].cn_notebook_id;
					var cn_notebook_name = books[i].cn_notebook_name;
					createBookLi(cn_notebook_id, cn_notebook_name);
				}

			},
			error : function() {
				console.log("加载失败");
			}
		});
	}

};

// 拼li元素
function createBookLi(cn_notebook_id, cn_notebook_name) {
	var sli = "";
	sli += '<li class="online">';
	sli += '  <a>';
	sli += '    <i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli += '    </i>';
	sli += cn_notebook_name;
	sli += '  </a>';
	sli += '</li>';
	var $li = $(sli);// 将sli字符串转成jQuery对象li元素
	$li.data("cn_notebook_id", cn_notebook_id);// 将值与jQuery对象元素绑定
	// 将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
};