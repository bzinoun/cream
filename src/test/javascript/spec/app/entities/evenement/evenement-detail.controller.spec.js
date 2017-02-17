'use strict';

describe('Controller Tests', function() {

    describe('Evenement Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockEvenement, MockTache;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockEvenement = jasmine.createSpy('MockEvenement');
            MockTache = jasmine.createSpy('MockTache');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Evenement': MockEvenement,
                'Tache': MockTache
            };
            createController = function() {
                $injector.get('$controller')("EvenementDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:evenementUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
