var selectionRect = {
	currentRect		: null,
	previousRect : null,
	currentY		: 0,
	currentX		: 0,
	originX			: 0,
	originY			: 0,
	
	setRectAndRememberPrevious: function(ele) {
		this.previousRect = this.currentRect;
		this.currentRect = ele;
		// this.previousRect.on("mouseover", handleMouseOver);
		// this.previousRect.on("mouseout", handleMouseOut);
	},

	getNewXYRecalculateWH: function() {
		var x = this.currentX<this.originX?this.currentX:this.originX;
		var y = this.currentY<this.originY?this.currentY:this.originY;
		var width = Math.abs(this.currentX - this.originX);
		var height = Math.abs(this.currentY - this.originY);
		return {
	        x       : x,
	        y       : y,
	        width  	: width,
	        height  : height
		};
	},
	getCurrentRectCoordsAsObject: function() {
		// use plus sign to convert string into number
		var x = +this.currentRect.attr("x");
		var y = +this.currentRect.attr("y");
		var width = +this.currentRect.attr("width");
		var height = +this.currentRect.attr("height");
		return {
			x1  : x,
	        y1	: y,
	        x2  : x + width,
	        y2  : y + height
		};
	},
	// thes will be listed at the top
	getCurrentRectCoordsAsText: function() {
		var rectCoords = this.getCurrentRectCoordsAsObject();
		return "x1: " + rectCoords.x1 + " x2: " + rectCoords.x2 + " y1: " + rectCoords.y1 + " y2: " + rectCoords.y2;
	},
	createNewRect: function(newX, newY) {
		// create a new rectangle
		nrect++;
		var rectElement = svg.append("rect")
		    .attr({
		        rx      : 4,
		        ry      : 4,
		        x       : 0,
		        y       : 0,
		        width   : 0,
		        height  : 0
		    })
		    .classed("selection", true);
	    this.setRectAndRememberPrevious(rectElement);
		this.originX = newX;
		this.originY = newY;
		this.updateXYandWH(newX, newY);
	},
	updateXYandWH: function(newX, newY) {
		this.currentX = newX;
		this.currentY = newY;
		this.currentRect.attr(this.getNewXYRecalculateWH());
	},
	updateStrokeAndWidth: function() {
		messageText.text("updateStrokeAndWidth");
        this.currentRect
            .style("stroke", annotator.color)
			.style("stroke-width", "2")
			.style("fill", "none");
			this.currentRect.id = annotator.type;
			this.currentRect.title = annotator.type;
			this.currentRect.append("title").text(annotator.type);
			this.currentRect.style("stroke-dasharray", "5 5");
		
    },
    removeCurrentRect: function() {
    	this.currentRect.remove();
    	this.currentRect = null;
    },
    removePreviousRect: function() {
		// this allows previous rect to be removed
		if (true) return
    	 if(this.previousRect) {
    	 	this.previousRect.remove();
    	 }
    }
	
};

// created by D3 from SVG
var svg = d3.select("svg");
// created from (p) elements with attributes
var clickTime = d3.select("#clicktime");
var attributesText = d3.select("#attributestext");
var messageText = d3.select("#messagetext");
var nrect = 0;


function dragStart() {
	message("dragStart");
    var xy = d3.mouse(this);
	messageText.text(""+xy);
    selectionRect.createNewRect(xy[0], xy[1]);
	selectionRect.removePreviousRect();
}

function dragMove() {
	message("dragMove");
	var xy = d3.mouse(this);
    selectionRect.updateXYandWH(xy[0], xy[1]);
    attributesText
    	.text(selectionRect.getCurrentRectCoordsAsText());
	selectionRect.currentRect.style("stroke-dasharray", "5 5");
}

function dragEnd() {
	message("dragEnd");
	var finalCoords = selectionRect.getCurrentRectCoordsAsObject();
	console.dir(finalCoords);
	if(finalCoords.x2 - finalCoords.x1 > 1 && finalCoords.y2 - finalCoords.y1 > 1){
		messageText.text("dragEnd");
		console.log("range selected");
		// range selected
		d3.event.sourceEvent.preventDefault();
		selectionRect.updateStrokeAndWidth();
		selectionRect.currentRect.style("stroke-dasharray", "");
		selectionRect.currentRect.attr("id", "rect_"+nrect);
//		selectionRect.currentRect.on("click", clickme);
		selectionRect.currentRect.on("mouseover", handleMouseOver());
		selectionRect.currentRect.on("mouseout", handleMouseOut());
		message("nrect "+nrect);
	} else {
		messageText.text("single point");		
		console.log("single point");
        // single point selected
        selectionRect.removeCurrentRect();
        // trigger click event manually
        clicked();
    }
}

function enterme() {
	message("ENTER");
}

var dragBehavior = d3.behavior.drag()
    .on("drag", dragMove)
    .on("dragstart", dragStart)
    .on("dragend", dragEnd);



svg.call(dragBehavior);

var annotator = {
		color : "red",
		type : "doi"
}


function handleMouseOver(d, i) {message("handleMouseOver");}
function handleMouseOut(d, i) {message("mouseOutX");}

function clicked() {
	var d = new Date();
    clickTime
    	.text("Clicked at " + d.toTimeString().substr(0,8) + ":" + d.getMilliseconds());
}
function setColorTypeReport(color, type) {
	message(type);
	annotator.color = color;
	annotator.type = type;
}

function message(message) {
	messageText.text(message);	console.log(message);
}
function selectDOI()         	{setColorTypeReport("red",     "doi");}
function selectTitle()       	{setColorTypeReport("green",   "title");}
function selectAuth()        	{setColorTypeReport("blue",    "auth");}
function selectAffil()       	{setColorTypeReport("cyan",    "affil");}
function selectEmail()       	{setColorTypeReport("orange",  "email");}
function selectAbstract()    	{setColorTypeReport("magenta", "abstract");}
function selectColumn()      	{setColorTypeReport("#ffaacc", "column");}
function selectSectionHead() 	{setColorTypeReport("cyan",    "section");}
function selectSubSectionHead() {setColorTypeReport("#77ffaa", "subSection");}
function selectBiblio()      	{setColorTypeReport("#ccff77", "biblio");}
function selectPage()        	{setColorTypeReport("#cc77ff", "page");}
function selectFigure()      	{setColorTypeReport("#ffcc77", "figure");}
function selectFigureCaption()  {setColorTypeReport("#77ccff", "figureCaption");}
function selectTable()       	{setColorTypeReport("#77ffcc", "table");}
function selectTableTitle()  	{setColorTypeReport("#00ccff", "tableTitle");}
function selectTableHead()   	{setColorTypeReport("#00ffcc", "tableHead");}
function selectTableBody()   	{setColorTypeReport("#ff00cc", "tableBody");}
function selectTableFoot() 	    {setColorTypeReport("#ffcc00", "tableFoot");}
function selectMaths()       	{setColorTypeReport("#ccff00", "maths");}
function selectReferences()  	{setColorTypeReport("#cc77aa", "references");}


// Create Event Handlers for mouse
function handleMouseOver(d, i) {  // Add interactivity

message("IN")
//      Use D3 to select element, change color and size
	message(d);
	selectionRect.currentRect.style("fill", "green");

      // // Specify where to put label of text
      // svg.append("text").attr({
      //    id: "t" + d.x + "-" + d.y + "-" + i,  // Create an id for text so we can select it later for removing on mouseout
      //     x: function() { return xScale(d.x) - 30; },
      //     y: function() { return yScale(d.y) - 15; }
      // })
      // .text(function() {
      //   return [d.x, d.y];  // Value of the text
      // });
    }

function handleMouseOut(d, i) {
message("OUT")
	selectionRect.currentRect.style("fill", "none");
      // // Use D3 to select element, change color back to normal
      // d3.select(this).attr({
      //   fill: "black",
      //   r: radius
      // });

      // // Select text by id and then remove
      // d3.select("#t" + d.x + "-" + d.y + "-" + i).remove();  // Remove text location
    }
