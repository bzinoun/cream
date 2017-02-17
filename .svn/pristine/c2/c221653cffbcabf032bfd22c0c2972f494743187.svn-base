'use strict';

describe('Controller Tests', function() {

    describe('Prospect Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockProspect, MockTache, MockCompagne, MockRefStatut;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockProspect = jasmine.createSpy('MockProspect');
            MockTache = jasmine.createSpy('MockTache');
            MockCompagne = jasmine.createSpy('MockCompagne');
            MockRefStatut = jasmine.createSpy('MockRefStatut');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Prospect': MockProspect,
                'Tache': MockTache,
                'Compagne': MockCompagne,
                'RefStatut': MockRefStatut
            };
            createController = function() {
                $injector.get('$controller')("ProspectDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:prospectUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
