package com.graphQl.graphQl.facet.converter;

import java.util.List;

public interface Convert<Target,Source>{

     Target convert(Target target, Source source);
     Source reConvert(Source source, Target target);

     List<Target> convertAll(List<Source> sourceList);
     List<Source> reConvertAll(List<Target> targetList);
}
