'use strict';

describe('Controller Tests', function() {

    describe('RefStatutCompagne Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockRefStatutCompagne, MockCompagne;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockRefStatutCompagne = jasmine.createSpy('MockRefStatutCompagne');
            MockCompagne = jasmine.createSpy('MockCompagne');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'RefStatutCompagne': MockRefStatutCompagne,
                'Compagne': MockCompagne
            };
            createController = function() {
                $injector.get('$controller')("RefStatutCompagneDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:refStatutCompagneUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
