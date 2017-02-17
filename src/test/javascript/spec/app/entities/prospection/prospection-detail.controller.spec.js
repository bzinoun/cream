'use strict';

describe('Controller Tests', function() {

    describe('Prospection Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockProspection, MockPersonne, MockCompagne, MockTache, MockRefStatutProspection;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockProspection = jasmine.createSpy('MockProspection');
            MockPersonne = jasmine.createSpy('MockPersonne');
            MockCompagne = jasmine.createSpy('MockCompagne');
            MockTache = jasmine.createSpy('MockTache');
            MockRefStatutProspection = jasmine.createSpy('MockRefStatutProspection');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Prospection': MockProspection,
                'Personne': MockPersonne,
                'Compagne': MockCompagne,
                'Tache': MockTache,
                'RefStatutProspection': MockRefStatutProspection
            };
            createController = function() {
                $injector.get('$controller')("ProspectionDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:prospectionUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
