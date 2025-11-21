/*
 * Copyright (c) 2025 Quant
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the “Software”),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.quant.quantregular.annotations;

import org.intellij.lang.annotations.Language;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Quant 팀이 정의한 형식이나 값을 따라야 합니다.
 * <p>
 * 다음과 같이 사용할 수 있습니다.
 * <pre>{@code
 * @QuantStd(reqEnv = {"USERNAME", "PW"})
 * class Authentication {
 *     // ... Impl
 * }
 * }</pre>
 * 위 경우 {@code Authentication} 타입의 멤버를 사용하려면 {@code USERNAME}과 {@code PW} 환경 변수가 할당되어 있어야 함을 의미합니다.
 * 이 어노테이션은 다음과 같은 방식으로도 사용할 수 있습니다.
 * <pre>{@code
 * class Main {
 *     void toStrOrInt(@QuantStd(reqType = {String.class, int.class}) Object type) {
 *         // ...
 *     }
 * }
 * }</pre>
 * 오브젝트 {@code type} 매개변수는 {@link String} 또는 <i>정수</i>로 바인딩되어야 함을 의미합니다.
 * <pre>{@code
 * class Main {
 *     @QuantStd(returnRule = "반환 문자열은 공백이 포함되어선 안 됩니다.")
 *     public String method() {
 *         return string.replace(" ", "");
 *     }
 * }
 * }</pre>
 * 위처럼 반환 규칙을 정의할 수도 있습니다.
 *
 * @author Q. T. Felix
 * @since 1.0.0
 */
@Retention(RetentionPolicy.SOURCE)
public @interface QuantStd {

    /**
     * 정의된 한경 변수를 마련하세요.
     */
    @Language("ENV")
    String[] reqEnv() default "";

    /**
     * 요소를 정의된 클래스로 바인딩하세요.
     */
    Class[] reqType() default int.class;

    /**
     * 반환 시 정의된 규칙을 따르세요.
     */
    String returnRule() default "";

}

