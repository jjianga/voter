
;(function($){
	$.fn.Xprompt = function(options){
		var defaults = {
			//各种参数，各种属性
			promptText:"222222",
			promptBtn:"ok0"
		};
		var options=$.extend({},defaults,options);
		this.each(function(){
			//各种功能  //可以理解成功能代码
			var promptHtml='';
			promptHtml +=['<div class="shade popup" style="z-index:60;">',
				'            <div class="content" style="width:60%;position:absolute;top:50%;left:15%;margin-top:-60px;">',
				'            <div class="popupBox" style="width:100%;height:130px;background:rgba(255,255,255,.9);border-radius:10px; box-shadow:4px 7px 17px #06c;">',
				'            <div class="toptop" style="width:100%;height:80px;  display:flex;flex-direction:column;align-content:center;justify-content:center;box-sizing: border-box; border-bottom:1px solid rgba(0,0,0,0.3);text-align:center;">',
				'            <div class="texttext" style="font-size:20px;font-weight:600;line-height:24px;margin:0 4px;">'+options.promptText+'</div>',
				'        </div>',
				'        <div class="popbottom" style="width:100%;height:50px;text-align:center;font-size:20px;line-height:50px; display:flex;flex-direction:column;align-content:center;justify-content:center;">',
				'            <p class="btnbtn" style="margin:0;font-size:20px;">'+options.promptBtn+'</p>',
				'            </div>',
				'            </div>',
				'            </div>',
				'            </div>'].join("");
			$(this).append(promptHtml);
			$(".popup .btnbtn").click(
				function () {
					$(this).parents(".popup").remove();
				})
		});
		return this;
	};
})(window.jQuery);

jQuery.fn.shake = function (intShakes /*Amount of shakes*/, intDistance /*Shake distance*/, intDuration /*Time duration*/) {
    this.each(function () {
        var jqNode = $(this);
        jqNode.css({ position: 'relative' });
        for (var x = 1; x <= intShakes; x++) {
            jqNode.animate({ left: (intDistance * -1) }, (((intDuration / intShakes) / 4)))
            .animate({ left: intDistance }, ((intDuration / intShakes) / 2))
            .animate({ left: 0 }, (((intDuration / intShakes) / 4)));
        }
    });
    return this;
}