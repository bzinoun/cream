'use strict';

angular.module('creamApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('home', {
                parent: 'site',
                url: '/',
                data: {
                    authorities: ['ROLE_USER' , 'ROLE_ADMIN' , 'ROLE_AGENT']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/main/main.html',
                        controller: 'MainController'
                    },
                    'calendar@home': {
                        templateUrl: 'scripts/components/calendar/calendar.html',
                        controller: 'CalendarController'
                    }
                
                },
                resolve: {
                	verfier : function ($q , $timeout,Principal , $state)
                	{var deferred = $q.defer();
                     	if(Principal.hasAnyAuthority(['ROLE_QUALIF']))
                		{ console.log("any true");
                     		$timeout(function() {
                     			$state.go('prospection')
                     		},0);
                     		return deferred.reject(); 
                		}
                     	else { 
                     		console.log("any false");
                		 return deferred.resolve(); 
                     	}
                     	
                	},
                    mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader , Principal , $state ) {
                        $translatePartialLoader.addPart('main');
                        $translatePartialLoader.addPart('compagne');
                        return $translate.refresh();
                    }]
                }
            })
 
            
            ;
        
        
        
    });
