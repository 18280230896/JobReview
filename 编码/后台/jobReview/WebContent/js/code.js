var javaEditor = CodeMirror.fromTextArea(document.getElementById("code"), {
            lineNumbers: true,
            matchBrackets: true,
            mode: "text/x-java"
        });
$("#run").click(function(){
	$("#run").text("运行中").prop("disabled","disabled");
	var code = javaEditor.getValue();
	$.ajax({
		url:"run.action",
		type:"post",
		dataType:"json",
		data:{"code":code},
		success:function(result){
			if(result.status == 1){
				$(".console").empty();
				var outarr = result.out.split("\n");
				for(var i = 0;i<outarr.length;i++){
					$(".console").append($("<p class='out'>"+outarr[i]+"</p>"))
				}
				var errarr = result.err.split("\n");
				for(var i = 0;i<errarr.length;i++){
					$(".console").append($("<p class='err'>"+errarr[i]+"</p>"));
				}
			}else if(result.status == 3){
				$(".console").empty();
				result.msg = result.msg.replace("D:\\jobReview\\temp\\","");
				var msgarr = result.msg.split("\n");
				for(var i = 0;i<msgarr.length;i++){
					$(".console").append($("<p class='err'>"+msgarr[i]+"</p>"));
				}
			}
			$("#run").text("运行").prop("disabled","");
		}
	});
});