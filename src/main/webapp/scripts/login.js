$(function(){
	//登录按钮单击事件
	$("#login").click(userLogin);
	//注册按钮的单击事件
	$("#regist_button").click(regist);
	//退出登录
	$("#logout").click(logout);
});

//注销登录
function logout(){
	$.ajax({
		url:path + "/user/logout.do",
		type:"post",
		//data:{userId:getCookie("userId")},
		dataType:"json",
		global:false,
		success:function(){
			delCookie("userId");
			window.location.href="log_in.html";
		},
		error:function(){
			alert("注销登录失败");
		}
	});
};

//注册功能
function regist() {
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	var userName = $("#regist_username").val().trim();
	var nickName = $("#nickname").val().trim();
	var password = $("#regist_password").val().trim();
	var password_final = $("#final_password").val().trim();
	
	var flag = true;	
	if(userName == ""){
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();
		var flag = false;
	}
	if(password == ""){
		$("#warning_2 span").html("密码不能为空");
		$("#warning_2").show();
		var flag = false;
	}
	if(password.length>0 && password.length<6){
		$("#warning_2 span").html("密码长度太短");
		$("#warning_2").show();
		var flag = false;
	}else if(password != password_final){
		$("#warning_3 span").html("两次密码不一致");
		$("#warning_3").show();
		var flag = false;
	}
	if(flag){
		$.ajax({
			url: path + "/user/regist.do",
			type: "post",
			data: {"userName":userName,"nickName":nickName,"password":password},
			dataType: "json",
			global:false,
			success:function(result){
				if(result.status == 0){
					alert("注册成功")
					//转到登录页面去
					$("#back").click();
					var username = result.data.cn_user_name;
					$("#regist_username").val("");
					$("#nickname").val("");
					$("#regist_password").val("");
					$("#final_password").val("");
					//再将用户名显示在登录界面上,并将登录页面的密码值为空
					$("#count").val(username);
					$("#password").val("");
				}else if(result.status == 1){
					console.log("用户名存在了");
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show();
				}
			},
			error: function() {
				alert("注册失败");
			}
		});
	}	
}


//登录功能
function userLogin() {
	//每次都要把前面的清除掉
	$("#count_span").html("");
	$("#password_span").html("");
	//获取参数
	var name = $("#count").val().trim();
	//console.log(name);
	var password = $("#password").val().trim();
	//console.log(password);
	
	var flag = true;
	if(name==""){
		flag = false;
		$("#count_span").html("用户名不能为空");
	}
	if(password==""){
		flag = false;
		$("#password_span").html("密码不能为空");
	}
	if(flag){
		//console.log("进入ajax");
		$.ajax({
			url: path + "/user/login.do",
			type: "post",
			data:{"name":name,"password":password},
			dataType:"json",
			global:false,
			success:function(result){
				if(result.status == 0){
					//获取user中的userId
					var userId = result.data.cn_user_id;
					var cn_user_name = result.data.cn_user_name;
					addCookie("userId",userId,2);
					addCookie("cn_user_name",cn_user_name,2);
					window.location.href = "edit.html";
				}else if(result.status == 1){
					$("#count_span").html(result.msg);
				}else if(result.status==2){//密码错
					$("#password_span").html(result.msg);
				}
			},
			error:function(){
				alert("登录失败");
			}
		});
	}
};