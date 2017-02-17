'use strict';

describe('Controller Tests', function() {

    describe('Tache Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockTache, MockProspection, MockAction, MockRefStatutTache;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockTache = jasmine.createSpy('MockTache');
            MockProspection = jasmine.createSpy('MockProspection');
            MockAction = jasmine.createSpy('MockAction');
            MockRefStatutTache = jasmine.createSpy('MockRefStatutTache');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Tache': MockTache,
                'Prospection': MockProspection,
                'Action': MockAction,
                'RefStatutTache': MockRefStatutTache
            };
            createController = function() {
                $injector.get('$controller')("TacheDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:tacheUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
