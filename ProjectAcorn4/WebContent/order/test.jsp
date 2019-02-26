<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
        <style type="text/css">
            .popup_panel { display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; z-index: 100;}
            .popup_panel div.popup_bg { position: absolute; top: 0; left: 0; width: 100%; height: 100%; background:#000; opacity:.5; filter:alpha(opacity=50); }
            .popup_panel div.popup_contents { position: absolute; top: 50%; left: 50%; width: 410px; height: 200px; border:2px solid #5294DE; background-color:#fff; }
        </style>
    </head>
    <body>
        <a href="javascript:void(0)" id="btn_popup_open">팝업 열기</a>
        <div class="popup_panel">
            <div class="popup_bg"></div>
            <div class="popup_contents">
            	
            	<table border="1">
            	 <tr>
            	  <td>a</td>
            	  <td>b</td>
            	 </tr>
            	 <tr>
            	  <td>c</td>
            	  <td>d</td>
            	 </tr>
            	</table>
            	
            	
                <br><a href="javascript:void(0)" id="btn_popup_close">팝업 닫기</a>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function() {
 
                var $panel = $(".popup_panel");
 
                var $panelContents = $panel.find(".popup_contents");
 
                $("#btn_popup_open").on("click", function(e) {
 
                    // 팝업 가운데 설정(가로)
                    if ($panelContents.outerWidth() < $(document).width()) {
                        $panelContents.css("margin-left", "-" + $panelContents.outerWidth() / 2 + "px");
                    } else {
                        $panelContents.css("left", "0px");
                    }
 
                    // 팝업 가운데 설정(세로)
                    if ($panelContents.outerHeight() < $(document).height()) {
                        $panelContents.css("margin-top", "-" + $panelContents.outerHeight() / 2 + "px");
                    } else {
                        $panelContents.css("top", "0px");
                    }
 
                    // 레이어 팝업 열기
                    $panel.fadeIn();
                });
 
                // 팝업 닫기 이벤트 정의
                $("#btn_popup_close").on("click", popupClose);
 
                // 팝업 배경 클릭 이벤트 정의
                $panel.find(".popup_bg").on("click", popupClose);
 
                function popupClose(e) {
 
                    $panel.fadeOut();
 
                    // 이벤트 기본 동작 중단
                    e.preventDefault();
                }
            });
        </script>
    </body>
</html>
    