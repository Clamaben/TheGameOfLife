var cellarrays;
function createTable(cellarrays) {
    //清空控件内容
    $("#table").empty();
    var rowCount = cellarrays.row;
    var colCount = cellarrays.col;
    $("#rowText").val(rowCount);
    $("#colText").val(colCount);
    var table = $("<table border='1' float:center>");
    table.appendTo($("#table"));
    var cells = cellarrays.cells;
    for (var i = 0; i < rowCount; ++i) {
        var tr = $("<tr></tr>");
        tr.appendTo(table);
        for (var j = 0; j < colCount; ++j) {
            var td;
            if (cells[i][j] == 0) {
                td = $("<td class='td-white' data-x='" + i + "' data-y='" + j + "' onclick=\"{checkCell(this)}\">" + "</td>");
            } else {
                td = $("<td class='td-black' data-x='" + i + "' data-y='" + j + "' onclick=\"{checkCell(this)}\">" + "</td>");
            }
            td.appendTo(tr);
        }
    }
    $("#table").append("</table>");
}
//点击细胞后反转其生死
function checkCell(cell) {
    var x = parseInt($(cell).attr("data-x"));
    var y = parseInt($(cell).attr("data-y"));
    var cells = cellarrays.cells;
    cells[x][y] = (cells[x][y] + 1) % 2;
    this.createTable(cellarrays);
}
	$("#initButton").click(function () {
    var rowCount = $("#rowText").val();
    var colCount = $("#colText").val();
    $.ajax({
        url: "mvc/init",
        type: "GET",
        dataType: "JSON",
        contentType: "application/json",
        data: {
            row: rowCount,
            col: colCount
        },
        success: function (result) {
        	cellarrays = result;
            createTable(cellarrays);
        }
    }); 
    $("#generateCount").val(0);
});
	$("#multiply_once").click(function(){
		var rowCount = $("#rowText").val();
	    var colCount = $("#colText").val();
	    var generateCount = $("#generateCount").val();
	    $.ajax({
	        type: "POST",
	        url: "mvc/multiply_once",
	        dataType: "JSON",
	        contentType: "application/json",
	        data: JSON.stringify(cellarrays),
	        success: function (result) {
	        	cellarrays = result;
	            createTable(cellarrays);
	        }
	    });
	    $("#generateCount").val(parseInt(generateCount) + 1);
	});
	var timer;
	$("#multiply_auto").click(function () {
		timer=setInterval(function(){
			var e = document.createEvent("MouseEvents");
			e.initEvent("click", true, true);
			document.getElementById("multiply_once").dispatchEvent(e);
		},500)
	});
	$("#multiply_stop").click(function () {
		window.clearInterval(timer); 
	});