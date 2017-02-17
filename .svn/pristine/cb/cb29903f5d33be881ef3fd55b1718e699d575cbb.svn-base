angular.module('creamApp')
.factory('Event', function ($resource, DateUtils) {
    return $resource('api/events/:id', {}, {
        'query': { method: 'GET', isArray: true},
        'get': {
            method: 'GET',
            transformResponse: function (data) {
                data = angular.fromJson(data);
                data.start = DateUtils.convertLocaleDateFromServer(data.start);
                data.end = DateUtils.convertLocaleDateFromServer(data.end);
                return data;
            }
        },
        'update': {
            method: 'PUT',
            transformRequest: function (data) {
                data.start = DateUtils.convertLocaleDateToServer(data.start);
                data.end = DateUtils.convertLocaleDateToServer(data.end);
                return angular.toJson(data);
            }
        },
        'save': {
            method: 'POST',
            transformRequest: function (data) {
                data.start = DateUtils.convertLocaleDateToServer(data.start);
                data.end = DateUtils.convertLocaleDateToServer(data.end);
                return angular.toJson(data);
            }
        }
    });
})


angular.module('creamApp')
    .controller('CalendarController', function ($resource,$scope,Event,Tache,$compile , uiCalendarConfig) {
    	
    	$scope.currentEvent =null ; 
    	var TacheAplanifier = $resource('/api/taches/a_planifier');
    	
    	
    	/* alert on eventClick */
        $scope.alertOnEventClick = function( date, jsEvent, view){
            $scope.alertMessage = (date.title + ' was clicked ');
        };
        /* alert on Drop */
         $scope.alertOnDrop = function(event, delta, revertFunc, jsEvent, ui, view){
        	 $scope.alertMessage = ('Event Droped to make dayDelta ' + delta + 'start : ' + event.start + 'end :' + event.end);
        	 $scope.currentEvent= {} ; 
        	 $scope.currentEvent.delta = {} ; 
        	 $scope.currentEvent.event = {} ; 

        	 $scope.currentEvent.event = event ; 
        	 $scope.currentEvent.delta = delta ; 
        };
        /* alert on Resize */
        $scope.alertOnResize = function(event, delta, revertFunc, jsEvent, ui, view ){
           $scope.alertMessage = ('Event Resized to make dayDelta ' + delta);
        };
    	
        /* Change View */
        $scope.changeView = function(view,calendar) {
          uiCalendarConfig.calendars[calendar].fullCalendar('changeView',view);
        };
        /* Change View */
        $scope.renderCalender = function(calendar) {
          if(uiCalendarConfig.calendars[calendar]){
            uiCalendarConfig.calendars[calendar].fullCalendar('render');
          }
        };
         /* Render Tooltip */
        $scope.eventRender = function( event, element, view ) { 
            element.attr({'tooltip': event.title,
                         'tooltip-append-to-body': true});
            $compile(element)($scope);
        };
        
        
        /* config object */
        $scope.uiConfig = {
          calendar:{
            height: "100%",
            editable: true,
            header:{
                left: 'prev,next today',
                center: 'title',
                right: 'month'
            },
            eventClick: $scope.alertOnEventClick,
            eventDrop: $scope.alertOnDrop,
            eventResize: $scope.alertOnResize,
            eventRender: $scope.eventRender
          }
        };
        
//        $scope.events = Event.query();
//        $scope.taches = Tache.query();
        
        $scope.loadAll= function(){
            $scope.events = Event.query();
            $scope.taches = TacheAplanifier.query();
        	
        }
        $scope.loadAll();
        $scope.eventSources = [$scope.events];

        
        $scope.$watch('currentEvent', function(newEvent) {
            if(newEvent){
            	console.log(newEvent);
            	console.log(newEvent.event.start._i);
            
            var eventDto = {};
            eventDto.id = newEvent.event.id ; 
            eventDto.start = newEvent.event.start._i ; 
            eventDto.end = event.end !=  null ? event.end._i : null  ; 
            eventDto.delta = newEvent.delta._days ; 
            Event.update(eventDto);
            }
        });
        
    });
