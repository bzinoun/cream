'use strict';

describe('Controller Tests', function() {

    describe('RefSecteurActivite Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockRefSecteurActivite, MockPersonne;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockRefSecteurActivite = jasmine.createSpy('MockRefSecteurActivite');
            MockPersonne = jasmine.createSpy('MockPersonne');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'RefSecteurActivite': MockRefSecteurActivite,
                'Personne': MockPersonne
            };
            createController = function() {
                $injector.get('$controller')("RefSecteurActiviteDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:refSecteurActiviteUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
