'use strict';

describe('Controller Tests', function() {

    describe('Personne Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPersonne, MockProspection, MockRefSituationFamiliale, MockRefSecteurActivite;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPersonne = jasmine.createSpy('MockPersonne');
            MockProspection = jasmine.createSpy('MockProspection');
            MockRefSituationFamiliale = jasmine.createSpy('MockRefSituationFamiliale');
            MockRefSecteurActivite = jasmine.createSpy('MockRefSecteurActivite');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Personne': MockPersonne,
                'Prospection': MockProspection,
                'RefSituationFamiliale': MockRefSituationFamiliale,
                'RefSecteurActivite': MockRefSecteurActivite
            };
            createController = function() {
                $injector.get('$controller')("PersonneDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:personneUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
