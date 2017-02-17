'use strict';

describe('Controller Tests', function() {

    describe('RefSituationFamiliale Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockRefSituationFamiliale, MockPersonne;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockRefSituationFamiliale = jasmine.createSpy('MockRefSituationFamiliale');
            MockPersonne = jasmine.createSpy('MockPersonne');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'RefSituationFamiliale': MockRefSituationFamiliale,
                'Personne': MockPersonne
            };
            createController = function() {
                $injector.get('$controller')("RefSituationFamilialeDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:refSituationFamilialeUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
