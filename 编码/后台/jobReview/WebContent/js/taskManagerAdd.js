//点击添加题目
var index = 1;
$("#addSubject").click(function(){
	var newNode = $("<div class='form-group add'>"+
						"<label class='control-label sr-only col-md-3'></label>"+
						"<div class='col-md-8'>"+
							"<div class='input-group'>"+
								"<textarea  type='text' class='form-control subjectName' name='subjects["+(index++)+"].name' placeholder='请输入题目'></textarea>"+
								"<span class='input-group-btn'>"+
									"<button type='button' class='btn btn-default delSubjectBtn'>"+
										"<span class='glyphicon glyphicon-remove delSubjectBtn'>"+
									"</button>"+
								"</span>"+
								"</span>"+
							"</div> "+
							"<span class='help-block'></span>"+
						"</div>"+
					"</div>");
	newNode.hide();
	$("#addTaskModal .form-group").eq(2).after(newNode);
	newNode.removeClass("hidden").slideDown(200);
});

$("form").click(function(event){
	//点击删除模块按钮
	if($(event.target).hasClass("delSubjectBtn")){
		var target;
		if(event.target.nodeName === "BUTTON"){
			target = $(event.target);
		}else if(event.target.nodeName === "SPAN"){
			target = $(event.target).parent();
		}
		target.parent().parent().parent().parent().slideUp(200,function(){
			target.parent().parent().parent().parent().remove();
		});
	}
});



