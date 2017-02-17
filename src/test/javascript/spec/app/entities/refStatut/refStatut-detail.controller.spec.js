'use strict';

describe('Controller Tests', function() {

    describe('RefStatut Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockRefStatut, MockProspect;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockRefStatut = jasmine.createSpy('MockRefStatut');
            MockProspect = jasmine.createSpy('MockProspect');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'RefStatut': MockRefStatut,
                'Prospect': MockProspect
            };
            createController = function() {
                $injector.get('$controller')("RefStatutDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:refStatutUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
