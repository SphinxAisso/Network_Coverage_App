import { SpyObject } from './spyobject';
import { ZsTrackerService } from '../../../../main/webapp/app/shared/tracker/tracker.service';

export class MockTrackerService extends SpyObject {

    constructor() {
        super(ZsTrackerService);
    }

    connect() {}
}
