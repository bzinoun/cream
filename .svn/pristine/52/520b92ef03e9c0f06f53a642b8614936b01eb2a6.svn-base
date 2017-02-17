'use strict';

describe('Controller Tests', function() {

    describe('RefStatutProspection Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockRefStatutProspection, MockProspection;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockRefStatutProspection = jasmine.createSpy('MockRefStatutProspection');
            MockProspection = jasmine.createSpy('MockProspection');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'RefStatutProspection': MockRefStatutProspection,
                'Prospection': MockProspection
            };
            createController = function() {
                $injector.get('$controller')("RefStatutProspectionDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:refStatutProspectionUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
