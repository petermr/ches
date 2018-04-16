/**
 *    Copyright 2011 Peter Murray-Rust et. al.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.contentmine.graphics.svg.fonts;

import java.util.HashMap;
import java.util.Map;

public class FontWidths {

	public static Map<String, double[]> fontWidthMap;
	
	// chars [0-255]
	// based on font size of 1.0
	// calculated 
	public final static double[] SANS_SERIF = {
		// sans-serif
        0.56, // [] 0
        1.06, // [] 1
        0.06, // [] 2
        0.06, // [] 3
        0.06, // [] 4
        0.06, // [] 5
        0.06, // [] 6
        0.06, // [] 7
        0.06, // [] 8 // TAB
        0.0, // [] 9
        0.0, // [] 10 // NL
        0.06, // [] 11
        0.06, // [] 12
        0.0, // [] 13 // DR
        0.06, // [] 14
        0.06, // [] 15
        0.06, // [] 16
        0.06, // [] 17
        0.06, // [] 18
        0.06, // [] 19
        0.06, // [] 20
        0.06, // [] 21
        0.06, // [] 22
        0.06, // [] 23
        0.06, // [] 24
        0.06, // [] 25
        0.06, // [] 26
        0.06, // [] 27
        0.06, // [] 28
        0.06, // [] 29
        0.06, // [] 30
        0.06, // [] 31
        0.28, //   32
        0.32, // ! 33
        0.47, // " 34
        0.56, // # 35
        0.56, // $ 36
        0.88, // % 37
        0.72, // & 38
        0.24, // ' 39
        0.33, // ( 40
        0.33, // ) 41
        0.39, // * 42
        0.58, // + 43
        0.28, // , 44
        0.33, // - 45
        0.28, // . 46
        0.28, // / 47
        0.56, // 0 48
        0.56, // 1 49
        0.56, // 2 50
        0.56, // 3 51
        0.56, // 4 52
        0.56, // 5 53
        0.56, // 6 54
        0.56, // 7 55
        0.56, // 8 56
        0.56, // 9 57
        0.34, // : 58
        0.34, // ; 59
        0.58, // < 60
        0.58, // = 61
        0.58, // > 62
        0.61, // ? 63
        0.98, // @ 64
        0.69, // A 65
        0.72, // B 66
        0.72, // C 67
        0.72, // D 68
        0.67, // E 69
        0.61, // F 70
        0.78, // G 71
        0.72, // H 72
        0.28, // I 73
        0.56, // J 74
        0.72, // K 75
        0.61, // L 76
        0.83, // M 77
        0.72, // N 78
        0.78, // O 79
        0.67, // P 80
        0.78, // Q 81
        0.72, // R 82
        0.67, // S 83
        0.61, // T 84
        0.72, // U 85
        0.67, // V 86
        0.95, // W 87
        0.67, // X 88
        0.66, // Y 89
        0.61, // Z 90
        0.33, // [ 91
        0.28, // \ 92
        0.33, // ] 93
        0.58, // ^ 94
        0.56, // _ 95
        0.33, // ` 96
        0.56, // a 97
        0.61, // b 98
        0.56, // c 99
        0.61, // d 100
        0.56, // e 101
        0.33, // f 102
        0.61, // g 103
        0.61, // h 104
        0.28, // i 105
        0.27, // j 106
        0.56, // k 107
        0.28, // l 108
        0.89, // m 109
        0.61, // n 110
        0.61, // o 111
        0.61, // p 112
        0.61, // q 113
        0.39, // r 114
        0.56, // s 115
        0.33, // t 116
        0.61, // u 117
        0.54, // v 118
        0.8, // w 119
        0.56, // x 120
        0.53, // y 121
        0.5, // z 122
        0.39, // { 123
        0.28, // | 124
        0.39, // } 125
        0.58, // ~ 126
        0.06, //  127
        0.06, // ? 128
        0.06, // ? 129
        0.56, // ? 130
        0.56, // ? 131
        0.56, // ? 132
        0.85, // ? 133
        0.56, // ? 134
        0.56, // ? 135
        0.42, // ? 136
        0.84, // ? 137
        0.54, // ? 138
        0.56, // ? 139
        1.06, // ? 140
        0.06, // ? 141
        0.06, // ? 142
        0.06, // ? 143
        0.06, // ? 144
        0.26, // ? 145
        0.26, // ? 146
        0.48, // ? 147
        0.48, // ? 148
        0.06, // ? 149
        0.59, // ? 150
        1.05, // ? 151
        0.4, // ? 152
        0.99, // ? 153
        0.42, // ? 154
        0.31, // ? 155
        0.62, // ? 156
        0.06, // ? 157
        0.06, // ? 158
        0.76, // ? 159
        0.28, // � 160
        0.34, // � 161
        0.56, // � 162
        0.56, // � 163
        0.56, // � 164
        0.56, // � 165
        0.28, // � 166
        0.56, // � 167
        0.33, // � 168
        0.74, // � 169
        0.37, // � 170
        0.56, // � 171
        0.58, // � 172
        0.33, // � 173
        0.74, // � 174
        0.55, // � 175
        0.4, // � 176
        0.55, // � 177
        0.33, // � 178
        0.33, // � 179
        0.33, // � 180
        0.58, // � 181
        0.56, // � 182
        0.33, // � 183
        0.32, // � 184
        0.33, // � 185
        0.37, // � 186
        0.56, // � 187
        0.83, // � 188
        0.83, // � 189
        0.83, // � 190
        0.61, // � 191
        0.69, // � 192
        0.69, // � 193
        0.69, // � 194
        0.69, // � 195
        0.69, // � 196
        0.69, // � 197
        1.0, // � 198
        0.72, // � 199
        0.67, // � 200
        0.67, // � 201
        0.67, // � 202
        0.67, // � 203
        0.28, // � 204
        0.28, // � 205
        0.28, // � 206
        0.28, // � 207
        0.72, // � 208
        0.72, // � 209
        0.78, // � 210
        0.78, // � 211
        0.78, // � 212
        0.78, // � 213
        0.78, // � 214
        0.58, // � 215
        0.78, // � 216
        0.72, // � 217
        0.72, // � 218
        0.72, // � 219
        0.72, // � 220
        0.66, // � 221
        0.67, // � 222
        0.61, // � 223
        0.56, // � 224
        0.56, // � 225
        0.56, // � 226
        0.56, // � 227
        0.56, // � 228
        0.56, // � 229
        0.89, // � 230
        0.56, // � 231
        0.56, // � 232
        0.56, // � 233
        0.56, // � 234
        0.56, // � 235
        0.28, // � 236
        0.28, // � 237
        0.28, // � 238
        0.28, // � 239
        0.61, // � 240
        0.61, // � 241
        0.61, // � 242
        0.61, // � 243
        0.61, // � 244
        0.61, // � 245
        0.61, // � 246
        0.55, // � 247
        0.61, // � 248
        0.61, // � 249
        0.61, // � 250
        0.61, // � 251
        0.61, // � 252
        0.53, // � 253
        0.61, // � 254
        0.53, // � 255
	};
    public final static double[] SERIF = {
        0.56, // [] 0
        1.06, // [] 1
        0.06, // [] 2
        0.06, // [] 3
        0.06, // [] 4
        0.06, // [] 5
        0.06, // [] 6
        0.06, // [] 7
        0.06, // [] 8
        0.0, // [] 9
        0.0, // [] 10
        0.06, // [] 11
        0.06, // [] 12
        0.0, // [] 13
        0.06, // [] 14
        0.06, // [] 15
        0.06, // [] 16
        0.06, // [] 17
        0.06, // [] 18
        0.06, // [] 19
        0.06, // [] 20
        0.06, // [] 21
        0.06, // [] 22
        0.06, // [] 23
        0.06, // [] 24
        0.06, // [] 25
        0.06, // [] 26
        0.06, // [] 27
        0.06, // [] 28
        0.06, // [] 29
        0.06, // [] 30
        0.06, // [] 31
        0.25, //   32
        0.33, // ! 33
        0.56, // " 34
        0.5, // # 35
        0.5, // $ 36
        1.01, // % 37
        0.83, // & 38
        0.28, // ' 39
        0.33, // ( 40
        0.33, // ) 41
        0.5, // * 42
        0.57, // + 43
        0.25, // , 44
        0.33, // - 45
        0.25, // . 46
        0.28, // / 47
        0.5, // 0 48
        0.5, // 1 49
        0.5, // 2 50
        0.5, // 3 51
        0.5, // 4 52
        0.5, // 5 53
        0.5, // 6 54
        0.5, // 7 55
        0.5, // 8 56
        0.5, // 9 57
        0.33, // : 58
        0.33, // ; 59
        0.57, // < 60
        0.57, // = 61
        0.57, // > 62
        0.5, // ? 63
        0.93, // @ 64
        0.72, // A 65
        0.67, // B 66
        0.72, // C 67
        0.72, // D 68
        0.67, // E 69
        0.6, // F 70
        0.77, // G 71
        0.78, // H 72
        0.39, // I 73
        0.5, // J 74
        0.77, // K 75
        0.67, // L 76
        0.94, // M 77
        0.72, // N 78
        0.78, // O 79
        0.6, // P 80
        0.78, // Q 81
        0.72, // R 82
        0.56, // S 83
        0.67, // T 84
        0.72, // U 85
        0.72, // V 86
        1.0, // W 87
        0.72, // X 88
        0.72, // Y 89
        0.66, // Z 90
        0.33, // [ 91
        0.28, // \ 92
        0.33, // ] 93
        0.58, // ^ 94
        0.5, // _ 95
        0.33, // ` 96
        0.5, // a 97
        0.56, // b 98
        0.44, // c 99
        0.56, // d 100
        0.44, // e 101
        0.34, // f 102
        0.5, // g 103
        0.56, // h 104
        0.28, // i 105
        0.33, // j 106
        0.56, // k 107
        0.28, // l 108
        0.82, // m 109
        0.56, // n 110
        0.5, // o 111
        0.56, // p 112
        0.56, // q 113
        0.44, // r 114
        0.39, // s 115
        0.33, // t 116
        0.56, // u 117
        0.5, // v 118
        0.73, // w 119
        0.5, // x 120
        0.5, // y 121
        0.44, // z 122
        0.39, // { 123
        0.21, // | 124
        0.39, // } 125
        0.52, // ~ 126
        0.06, //  127
        0.06, // ? 128
        0.06, // ? 129
        0.56, // ? 130
        0.56, // ? 131
        0.56, // ? 132
        0.85, // ? 133
        0.56, // ? 134
        0.56, // ? 135
        0.42, // ? 136
        0.84, // ? 137
        0.54, // ? 138
        0.56, // ? 139
        1.06, // ? 140
        0.06, // ? 141
        0.06, // ? 142
        0.06, // ? 143
        0.06, // ? 144
        0.26, // ? 145
        0.26, // ? 146
        0.48, // ? 147
        0.48, // ? 148
        0.06, // ? 149
        0.59, // ? 150
        1.05, // ? 151
        0.4, // ? 152
        0.99, // ? 153
        0.42, // ? 154
        0.31, // ? 155
        0.62, // ? 156
        0.06, // ? 157
        0.06, // ? 158
        0.76, // ? 159
        0.25, // � 160
        0.34, // � 161
        0.5, // � 162
        0.5, // � 163
        0.5, // � 164
        0.5, // � 165
        0.21, // � 166
        0.5, // � 167
        0.36, // � 168
        0.75, // � 169
        0.3, // � 170
        0.5, // � 171
        0.57, // � 172
        0.33, // � 173
        0.75, // � 174
        0.5, // � 175
        0.4, // � 176
        0.55, // � 177
        0.3, // � 178
        0.3, // � 179
        0.33, // � 180
        0.58, // � 181
        0.54, // � 182
        0.33, // � 183
        0.33, // � 184
        0.3, // � 185
        0.33, // � 186
        0.5, // � 187
        0.75, // � 188
        0.75, // � 189
        0.75, // � 190
        0.5, // � 191
        0.72, // � 192
        0.72, // � 193
        0.72, // � 194
        0.72, // � 195
        0.72, // � 196
        0.72, // � 197
        1.0, // � 198
        0.72, // � 199
        0.67, // � 200
        0.67, // � 201
        0.67, // � 202
        0.67, // � 203
        0.39, // � 204
        0.39, // � 205
        0.39, // � 206
        0.39, // � 207
        0.72, // � 208
        0.72, // � 209
        0.78, // � 210
        0.78, // � 211
        0.78, // � 212
        0.78, // � 213
        0.78, // � 214
        0.57, // � 215
        0.78, // � 216
        0.72, // � 217
        0.72, // � 218
        0.72, // � 219
        0.72, // � 220
        0.72, // � 221
        0.61, // � 222
        0.56, // � 223
        0.5, // � 224
        0.5, // � 225
        0.5, // � 226
        0.5, // � 227
        0.5, // � 228
        0.5, // � 229
        0.72, // � 230
        0.44, // � 231
        0.44, // � 232
        0.44, // � 233
        0.44, // � 234
        0.44, // � 235
        0.28, // � 236
        0.28, // � 237
        0.28, // � 238
        0.28, // � 239
        0.5, // � 240
        0.56, // � 241
        0.5, // � 242
        0.5, // � 243
        0.5, // � 244
        0.5, // � 245
        0.5, // � 246
        0.55, // � 247
        0.5, // � 248
        0.56, // � 249
        0.56, // � 250
        0.56, // � 251
        0.56, // � 252
        0.5, // � 253
        0.56, // � 254
        0.5, // � 255
    	};
    
    public final static String HELVETICA = "helvetica";
    public final static String TIMES_ROMAN = "times-roman";
	private static void ensureFontWidthMap() {
		if (fontWidthMap == null) {
			fontWidthMap = new HashMap<String, double[]>();
			fontWidthMap.put("serif", SERIF);
			fontWidthMap.put(TIMES_ROMAN, SERIF);
			fontWidthMap.put(HELVETICA, SANS_SERIF);
			fontWidthMap.put("sans-serif", SANS_SERIF);
		}
	}

    public final static double[] getFontWidths(String family) {
		ensureFontWidthMap();
		double[] widths = (family == null) ? null : fontWidthMap.get(family.toLowerCase());
		return (widths == null) ? fontWidthMap.get(HELVETICA) : widths;
	}
}