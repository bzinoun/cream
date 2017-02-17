'use strict';

describe('Controller Tests', function() {

    describe('Agent Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockAgent, MockUser, MockTache;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockAgent = jasmine.createSpy('MockAgent');
            MockUser = jasmine.createSpy('MockUser');
            MockTache = jasmine.createSpy('MockTache');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Agent': MockAgent,
                'User': MockUser,
                'Tache': MockTache
            };
            createController = function() {
                $injector.get('$controller')("AgentDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'creamApp:agentUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
