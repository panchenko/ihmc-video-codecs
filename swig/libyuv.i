%module libyuv
%include "enums.swg"
%include "arrays_java.i"
%include "typemaps.i"
%include "various.i"
%apply unsigned char *NIOBUFFER { unsigned char* };

%typemap(jni) enum RotationMode "RotationModeEnum";
%typemap(jstype) enum RotationMode "RotationModeEnum";
#%typemap(jtype) enum RotationMode "RotationModeEnum";

%javaconst(1);
%{
#include "libyuv.h"
using namespace libyuv;
%}


%include "libyuv/basic_types.h"
%include "libyuv/compare.h"
%include "libyuv/convert.h"
%include "libyuv/convert_argb.h"
%include "libyuv/convert_from.h"
%include "libyuv/convert_from_argb.h"
%include "libyuv/format_conversion.h"
#%include "libyuv/mjpeg_decoder.h"
%include "libyuv/planar_functions.h"
%include "libyuv/rotate.h"
%include "libyuv/rotate_argb.h"
%include "libyuv/row.h"
%include "libyuv/scale.h"
%include "libyuv/scale_argb.h"
%include "libyuv/scale_row.h"
%include "libyuv/version.h"
#%include "libyuv/video_common.h"
