'use strict';

describe('Controller Tests', function() {

    describe('RefStatutTache Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockRefStatutTache, MockTache;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockRefStatutTache = jasmine.createSpy('MockRefStatutTache');
            MockTache = jasmine.createSpy('MockTache');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'RefStatutTache': MockRefStatutTache,
                'Tache': MockTache
            };
            createController = function() {
                $injector.get('$controller')("RefStatutTacheDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:refStatutTacheUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
