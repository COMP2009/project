$(document).ready(function() {
	$('#calendar').fullCalendar({
	    theme: true,
	    editable: false,
	    events: "events",
	    defaultView: "agendaWeek",
	    allDaySlot: false,
	    scrollTime: '13:00:00',
	    minTime:'12:00:00',
	    maxTime:'24:00:00',
	    businessHours: {
	    	    start: '14:00', // a start time (10am in this example)
	    	    end: '22:00', // an end time (6pm in this example)

	    	    dow: [ 0, 1, 2, 3, 4, 5, 6]
	    	    // days of week. an array of zero-based day of week integers (0=Sunday)
	    	    // (Monday-Thursday in this example)
	    	}
	});
});