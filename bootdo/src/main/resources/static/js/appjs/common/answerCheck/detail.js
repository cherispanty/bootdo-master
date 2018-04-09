$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		//校验参数
		var score = $('#score').val();
		console.log("score:"+score);
		if(score == '' || typeof (score) == 'undefined' || score == null) {
            parent.layer.alert("分数不能为空");
            return;
		}
		if(score < 0 || score > 100) {
            parent.layer.alert("分数只能在【0,100】");
            return;
		}
		if(isNaN(score)) {
            parent.layer.alert("分数必须是数值型");
            return;
		}
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/common/answerCheck/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            }
        },
        messages : {
            name : {
                required : icon + "请输入名字"
            }
        }
    })
}