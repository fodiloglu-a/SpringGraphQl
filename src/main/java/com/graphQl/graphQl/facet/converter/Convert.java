package com.graphQl.graphQl.facet.converter;

public interface Convert<Target,Source>{

     void convert(Target target,Source source);
     void reConvert(Source source,Target target);
}
