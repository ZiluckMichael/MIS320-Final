import * as _ from 'lodash';

export const not = (arg) => !arg;

export const and = (...args) => _.reduce(args, (acc, next) => next ? acc : next, true);
export const nand = _.compose(not, and);

export const or = (...args) => _.reduce(args, (acc, next) => not(next) ? acc : next, false);
export const nor = _.compose(not, or);

export const xor = (...args) => _.reduce(args, (acc, next) => or(and(not(acc), next), and(acc, not(next))), false);
export const xnor = _.compose(not, xor);

