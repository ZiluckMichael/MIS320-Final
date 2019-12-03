import { LogicalUtil } from 'src/app/shared/utils/logical.util';

describe('LogicalUtil', () => {
    const util: LogicalUtil = new LogicalUtil();

    it('not() works', () => {
        expect(util.not(true)).toBe(false);
        expect(util.not(false)).toBe(true);
    });
});
