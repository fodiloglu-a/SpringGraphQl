package com.graphQl.graphQl.facet.populator;

public interface Populator<Target, Source> {

    Target populate(Target target, Source source);
    Source rePopulate(Source source,Target target);
}
