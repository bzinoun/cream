'use strict';

describe('Controller Tests', function() {

    describe('Compagne Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockCompagne, MockProspection, MockRefStatutCompagne;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockCompagne = jasmine.createSpy('MockCompagne');
            MockProspection = jasmine.createSpy('MockProspection');
            MockRefStatutCompagne = jasmine.createSpy('MockRefStatutCompagne');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Compagne': MockCompagne,
                'Prospection': MockProspection,
                'RefStatutCompagne': MockRefStatutCompagne
            };
            createController = function() {
                $injector.get('$controller')("CompagneDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:compagneUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
