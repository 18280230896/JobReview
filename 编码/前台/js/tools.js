//禁止tab默认切换焦点事件
window.addEventListener('keydown', function(e){
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 9){
        e.preventDefault();
    }
})

$("#content").keypress(function(e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13){
    	e.preventDefault();
        $("#content").append("<p><br></p>");
        $("#content").focus();
    }
});