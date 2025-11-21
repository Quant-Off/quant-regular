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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Quant 팀은 해당 어노테이션이 사용된 타입, 멤버 등을 외부에 공개할 수 없습니다.
 * <p>
 * 팀 멤버는 해당 요소를 외부의 시선이 닿는 공간에 보관해선 안 됩니다.
 *
 * @author Q. T. Felix
 * @since 1.0.0
 */
@Retention(RetentionPolicy.SOURCE)
public @interface QuantCredential {

    /**
     * 공개를 최초로 금지한 사용자를 정의합니다.
     *
     * @return 공개를 최초로 금지한 사용자
     */
    String[] user();

    /**
     * 공개 금지 사유입니다.
     *
     * @return 공개 금지 사유
     */
    String reason();

}
