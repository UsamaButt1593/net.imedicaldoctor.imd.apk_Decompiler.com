package org.jsoup.parser;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.html.HTML;
import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.nodes.DocumentType;
import org.jsoup.parser.Token;

enum TokeniserState {
    Data {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char q = characterReader.q();
            if (q != 0) {
                if (q == '&') {
                    tokeniserState = TokeniserState.CharacterReferenceInData;
                } else if (q == '<') {
                    tokeniserState = TokeniserState.TagOpen;
                } else if (q != 65535) {
                    tokeniser.l(characterReader.e());
                    return;
                } else {
                    tokeniser.m(new Token.EOF());
                    return;
                }
                tokeniser.b(tokeniserState);
                return;
            }
            tokeniser.u(this);
            tokeniser.k(characterReader.c());
        }
    },
    CharacterReferenceInData {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.o(tokeniser, TokeniserState.Data);
        }
    },
    Rcdata {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char q = characterReader.q();
            if (q != 0) {
                if (q == '&') {
                    tokeniserState = TokeniserState.CharacterReferenceInRcdata;
                } else if (q == '<') {
                    tokeniserState = TokeniserState.RcdataLessthanSign;
                } else if (q != 65535) {
                    tokeniser.l(characterReader.m(Typography.f29117d, '<', 0));
                    return;
                } else {
                    tokeniser.m(new Token.EOF());
                    return;
                }
                tokeniser.b(tokeniserState);
                return;
            }
            tokeniser.u(this);
            characterReader.a();
            tokeniser.k(65533);
        }
    },
    CharacterReferenceInRcdata {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.o(tokeniser, TokeniserState.Rcdata);
        }
    },
    Rawtext {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.p(tokeniser, characterReader, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.p(tokeniser, characterReader, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            char q = characterReader.q();
            if (q == 0) {
                tokeniser.u(this);
                characterReader.a();
                tokeniser.k(65533);
            } else if (q != 65535) {
                tokeniser.l(characterReader.k(0));
            } else {
                tokeniser.m(new Token.EOF());
            }
        }
    },
    TagOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            char q = characterReader.q();
            if (q == '!') {
                tokeniserState = TokeniserState.MarkupDeclarationOpen;
            } else if (q == '/') {
                tokeniserState = TokeniserState.EndTagOpen;
            } else if (q != '?') {
                if (characterReader.B()) {
                    tokeniser.h(true);
                    tokeniserState2 = TokeniserState.TagName;
                } else {
                    tokeniser.u(this);
                    tokeniser.k('<');
                    tokeniserState2 = TokeniserState.Data;
                }
                tokeniser.y(tokeniserState2);
                return;
            } else {
                tokeniserState = TokeniserState.BogusComment;
            }
            tokeniser.b(tokeniserState);
        }
    },
    EndTagOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.r()) {
                tokeniser.s(this);
                tokeniser.l("</");
                tokeniserState = TokeniserState.Data;
            } else if (characterReader.B()) {
                tokeniser.h(false);
                tokeniserState = TokeniserState.TagName;
            } else {
                boolean v = characterReader.v('>');
                tokeniser.u(this);
                tokeniser.b(v ? TokeniserState.Data : TokeniserState.BogusComment);
                return;
            }
            tokeniser.y(tokeniserState);
        }
    },
    TagName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            tokeniser.f31702i.v(characterReader.j());
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != ' ') {
                    if (c2 != '/') {
                        if (c2 == '>') {
                            tokeniser.r();
                        } else if (c2 == 65535) {
                            tokeniser.s(this);
                        } else if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13)) {
                            return;
                        }
                        tokeniserState = TokeniserState.Data;
                    } else {
                        tokeniserState = TokeniserState.SelfClosingStartTag;
                    }
                    tokeniser.y(tokeniserState);
                    return;
                }
                tokeniserState = TokeniserState.BeforeAttributeName;
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.f31702i.v(TokeniserState.o4);
        }
    },
    RcdataLessthanSign {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.v('/')) {
                tokeniser.i();
                tokeniser.b(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (characterReader.B() && tokeniser.c() != null) {
                if (!characterReader.p("</" + tokeniser.c())) {
                    tokeniser.f31702i = tokeniser.h(false).B(tokeniser.c());
                    tokeniser.r();
                    characterReader.H();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.y(tokeniserState);
                }
            }
            tokeniser.l("<");
            tokeniserState = TokeniserState.Rcdata;
            tokeniser.y(tokeniserState);
        }
    },
    RCDATAEndTagOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.h(false);
                tokeniser.f31702i.u(characterReader.q());
                tokeniser.f31701h.append(characterReader.q());
                tokeniser.b(TokeniserState.RCDATAEndTagName);
                return;
            }
            tokeniser.l("</");
            tokeniser.y(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagName {
        private void r(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.l("</" + tokeniser.f31701h.toString());
            characterReader.H();
            tokeniser.y(TokeniserState.Rcdata);
        }

        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.B()) {
                String h2 = characterReader.h();
                tokeniser.f31702i.v(h2);
                tokeniser.f31701h.append(h2);
                return;
            }
            char c2 = characterReader.c();
            if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
                if (tokeniser.w()) {
                    tokeniserState = TokeniserState.BeforeAttributeName;
                    tokeniser.y(tokeniserState);
                    return;
                }
            } else if (c2 != '/') {
                if (c2 == '>' && tokeniser.w()) {
                    tokeniser.r();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.y(tokeniserState);
                    return;
                }
            } else if (tokeniser.w()) {
                tokeniserState = TokeniserState.SelfClosingStartTag;
                tokeniser.y(tokeniserState);
                return;
            }
            r(tokeniser, characterReader);
        }
    },
    RawtextLessthanSign {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('/')) {
                tokeniser.i();
                tokeniser.b(TokeniserState.RawtextEndTagOpen);
                return;
            }
            tokeniser.k('<');
            tokeniser.y(TokeniserState.Rawtext);
        }
    },
    RawtextEndTagOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.q(tokeniser, characterReader, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.m(tokeniser, characterReader, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == '!') {
                tokeniser.l("<!");
                tokeniserState = TokeniserState.ScriptDataEscapeStart;
            } else if (c2 != '/') {
                tokeniser.l("<");
                characterReader.H();
                tokeniserState = TokeniserState.ScriptData;
            } else {
                tokeniser.i();
                tokeniserState = TokeniserState.ScriptDataEndTagOpen;
            }
            tokeniser.y(tokeniserState);
        }
    },
    ScriptDataEndTagOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.q(tokeniser, characterReader, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.m(tokeniser, characterReader, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('-')) {
                tokeniser.k('-');
                tokeniser.b(TokeniserState.ScriptDataEscapeStartDash);
                return;
            }
            tokeniser.y(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStartDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('-')) {
                tokeniser.k('-');
                tokeniser.b(TokeniserState.ScriptDataEscapedDashDash);
                return;
            }
            tokeniser.y(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscaped {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.r()) {
                tokeniser.s(this);
                tokeniser.y(TokeniserState.Data);
                return;
            }
            char q = characterReader.q();
            if (q != 0) {
                if (q == '-') {
                    tokeniser.k('-');
                    tokeniserState = TokeniserState.ScriptDataEscapedDash;
                } else if (q != '<') {
                    tokeniser.l(characterReader.m('-', '<', 0));
                    return;
                } else {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.b(tokeniserState);
                return;
            }
            tokeniser.u(this);
            characterReader.a();
            tokeniser.k(65533);
        }
    },
    ScriptDataEscapedDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.r()) {
                tokeniser.s(this);
                tokeniser.y(TokeniserState.Data);
                return;
            }
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 == '-') {
                    tokeniser.k(c2);
                    tokeniserState = TokeniserState.ScriptDataEscapedDashDash;
                } else if (c2 == '<') {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            c2 = 65533;
            tokeniser.k(c2);
            tokeniserState = TokeniserState.ScriptDataEscaped;
            tokeniser.y(tokeniserState);
        }
    },
    ScriptDataEscapedDashDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.r()) {
                tokeniser.s(this);
                tokeniser.y(TokeniserState.Data);
                return;
            }
            char c2 = characterReader.c();
            if (c2 == 0) {
                tokeniser.u(this);
                tokeniser.k(65533);
            } else if (c2 != '-') {
                if (c2 != '<') {
                    tokeniser.k(c2);
                    if (c2 == '>') {
                        tokeniserState = TokeniserState.ScriptData;
                    }
                } else {
                    tokeniserState = TokeniserState.ScriptDataEscapedLessthanSign;
                }
                tokeniser.y(tokeniserState);
            } else {
                tokeniser.k(c2);
                return;
            }
            tokeniserState = TokeniserState.ScriptDataEscaped;
            tokeniser.y(tokeniserState);
        }
    },
    ScriptDataEscapedLessthanSign {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.B()) {
                tokeniser.i();
                tokeniser.f31701h.append(characterReader.q());
                tokeniser.l("<" + characterReader.q());
                tokeniserState = TokeniserState.ScriptDataDoubleEscapeStart;
            } else if (characterReader.v('/')) {
                tokeniser.i();
                tokeniserState = TokeniserState.ScriptDataEscapedEndTagOpen;
            } else {
                tokeniser.k('<');
                tokeniser.y(TokeniserState.ScriptDataEscaped);
                return;
            }
            tokeniser.b(tokeniserState);
        }
    },
    ScriptDataEscapedEndTagOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.B()) {
                tokeniser.h(false);
                tokeniser.f31702i.u(characterReader.q());
                tokeniser.f31701h.append(characterReader.q());
                tokeniser.b(TokeniserState.ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.l("</");
            tokeniser.y(TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.m(tokeniser, characterReader, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char q = characterReader.q();
            if (q != 0) {
                if (q == '-') {
                    tokeniser.k(q);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedDash;
                } else if (q == '<') {
                    tokeniser.k(q);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (q != 65535) {
                    tokeniser.l(characterReader.m('-', '<', 0));
                    return;
                } else {
                    tokeniser.s(this);
                    tokeniser.y(TokeniserState.Data);
                    return;
                }
                tokeniser.b(tokeniserState);
                return;
            }
            tokeniser.u(this);
            characterReader.a();
            tokeniser.k(65533);
        }
    },
    ScriptDataDoubleEscapedDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 == '-') {
                    tokeniser.k(c2);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedDashDash;
                } else if (c2 == '<') {
                    tokeniser.k(c2);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (c2 == 65535) {
                    tokeniser.s(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            c2 = 65533;
            tokeniser.k(c2);
            tokeniserState = TokeniserState.ScriptDataDoubleEscaped;
            tokeniser.y(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedDashDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 0) {
                tokeniser.u(this);
                c2 = 65533;
            } else if (c2 != '-') {
                if (c2 == '<') {
                    tokeniser.k(c2);
                    tokeniserState = TokeniserState.ScriptDataDoubleEscapedLessthanSign;
                } else if (c2 == '>') {
                    tokeniser.k(c2);
                    tokeniserState = TokeniserState.ScriptData;
                } else if (c2 == 65535) {
                    tokeniser.s(this);
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.y(tokeniserState);
            } else {
                tokeniser.k(c2);
                return;
            }
            tokeniser.k(c2);
            tokeniserState = TokeniserState.ScriptDataDoubleEscaped;
            tokeniser.y(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.v('/')) {
                tokeniser.k('/');
                tokeniser.i();
                tokeniser.b(TokeniserState.ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.y(TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.l(tokeniser, characterReader, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 0) {
                tokeniser.u(this);
            } else if (c2 != ' ') {
                if (!(c2 == '\"' || c2 == '\'')) {
                    if (c2 != '/') {
                        if (c2 != 65535) {
                            if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13) {
                                switch (c2) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.r();
                                        break;
                                }
                            } else {
                                return;
                            }
                        } else {
                            tokeniser.s(this);
                        }
                        tokeniserState = TokeniserState.Data;
                    } else {
                        tokeniserState = TokeniserState.SelfClosingStartTag;
                    }
                    tokeniser.y(tokeniserState);
                }
                tokeniser.u(this);
                tokeniser.f31702i.C();
                tokeniser.f31702i.o(c2);
                tokeniserState = TokeniserState.AttributeName;
                tokeniser.y(tokeniserState);
            } else {
                return;
            }
            tokeniser.f31702i.C();
            characterReader.H();
            tokeniserState = TokeniserState.AttributeName;
            tokeniser.y(tokeniserState);
        }
    },
    AttributeName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            tokeniser.f31702i.p(characterReader.n(TokeniserState.l4));
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != ' ') {
                    if (!(c2 == '\"' || c2 == '\'')) {
                        if (c2 != '/') {
                            if (c2 == 65535) {
                                tokeniser.s(this);
                            } else if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13)) {
                                switch (c2) {
                                    case '<':
                                        break;
                                    case '=':
                                        tokeniserState = TokeniserState.BeforeAttributeValue;
                                        break;
                                    case '>':
                                        tokeniser.r();
                                        break;
                                    default:
                                        return;
                                }
                            }
                            tokeniserState = TokeniserState.Data;
                        } else {
                            tokeniserState = TokeniserState.SelfClosingStartTag;
                        }
                        tokeniser.y(tokeniserState);
                        return;
                    }
                    tokeniser.u(this);
                    tag = tokeniser.f31702i;
                }
                tokeniserState = TokeniserState.AfterAttributeName;
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            tag = tokeniser.f31702i;
            c2 = 65533;
            tag.o(c2);
        }
    },
    AfterAttributeName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 0) {
                tokeniser.u(this);
                tag = tokeniser.f31702i;
                c2 = 65533;
                tag.o(c2);
            } else if (c2 != ' ') {
                if (!(c2 == '\"' || c2 == '\'')) {
                    if (c2 != '/') {
                        if (c2 != 65535) {
                            if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13) {
                                switch (c2) {
                                    case '<':
                                        break;
                                    case '=':
                                        tokeniserState = TokeniserState.BeforeAttributeValue;
                                        break;
                                    case '>':
                                        tokeniser.r();
                                        break;
                                    default:
                                        tokeniser.f31702i.C();
                                        characterReader.H();
                                        break;
                                }
                            } else {
                                return;
                            }
                        } else {
                            tokeniser.s(this);
                        }
                        tokeniserState = TokeniserState.Data;
                    } else {
                        tokeniserState = TokeniserState.SelfClosingStartTag;
                    }
                    tokeniser.y(tokeniserState);
                }
                tokeniser.u(this);
                tokeniser.f31702i.C();
                tag = tokeniser.f31702i;
                tag.o(c2);
            } else {
                return;
            }
            tokeniserState = TokeniserState.AttributeName;
            tokeniser.y(tokeniserState);
        }
    },
    BeforeAttributeValue {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 0) {
                tokeniser.u(this);
                tag = tokeniser.f31702i;
                c2 = 65533;
                tag.q(c2);
            } else if (c2 != ' ') {
                if (c2 != '\"') {
                    if (c2 != '`') {
                        if (c2 == 65535) {
                            tokeniser.s(this);
                        } else if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13) {
                            if (c2 != '&') {
                                if (c2 != '\'') {
                                    switch (c2) {
                                        case '<':
                                        case '=':
                                            break;
                                        case '>':
                                            tokeniser.u(this);
                                            break;
                                    }
                                } else {
                                    tokeniserState = TokeniserState.AttributeValue_singleQuoted;
                                }
                            }
                            characterReader.H();
                        } else {
                            return;
                        }
                        tokeniser.r();
                        tokeniserState = TokeniserState.Data;
                    }
                    tokeniser.u(this);
                    tag = tokeniser.f31702i;
                    tag.q(c2);
                } else {
                    tokeniserState = TokeniserState.AttributeValue_doubleQuoted;
                }
                tokeniser.y(tokeniserState);
            } else {
                return;
            }
            tokeniserState = TokeniserState.AttributeValue_unquoted;
            tokeniser.y(tokeniserState);
        }
    },
    AttributeValue_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            String m2 = characterReader.m(TokeniserState.k4);
            if (m2.length() > 0) {
                tokeniser.f31702i.r(m2);
            } else {
                tokeniser.f31702i.F();
            }
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 == '\"') {
                    tokeniserState = TokeniserState.AfterAttributeValue_quoted;
                } else if (c2 == '&') {
                    int[] e2 = tokeniser.e('\"', true);
                    Token.Tag tag = tokeniser.f31702i;
                    if (e2 != null) {
                        tag.t(e2);
                        return;
                    } else {
                        tag.q(Typography.f29117d);
                        return;
                    }
                } else if (c2 == 65535) {
                    tokeniser.s(this);
                    tokeniserState = TokeniserState.Data;
                } else {
                    return;
                }
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            tokeniser.f31702i.q(65533);
        }
    },
    AttributeValue_singleQuoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            String m2 = characterReader.m(TokeniserState.j4);
            if (m2.length() > 0) {
                tokeniser.f31702i.r(m2);
            } else {
                tokeniser.f31702i.F();
            }
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 == 65535) {
                    tokeniser.s(this);
                    tokeniserState = TokeniserState.Data;
                } else if (c2 == '&') {
                    int[] e2 = tokeniser.e('\'', true);
                    Token.Tag tag = tokeniser.f31702i;
                    if (e2 != null) {
                        tag.t(e2);
                        return;
                    } else {
                        tag.q(Typography.f29117d);
                        return;
                    }
                } else if (c2 == '\'') {
                    tokeniserState = TokeniserState.AfterAttributeValue_quoted;
                } else {
                    return;
                }
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            tokeniser.f31702i.q(65533);
        }
    },
    AttributeValue_unquoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            Token.Tag tag;
            TokeniserState tokeniserState;
            String n2 = characterReader.n(TokeniserState.m4);
            if (n2.length() > 0) {
                tokeniser.f31702i.r(n2);
            }
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != ' ') {
                    if (!(c2 == '\"' || c2 == '`')) {
                        if (c2 == 65535) {
                            tokeniser.s(this);
                        } else if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13)) {
                            if (c2 == '&') {
                                int[] e2 = tokeniser.e('>', true);
                                Token.Tag tag2 = tokeniser.f31702i;
                                if (e2 != null) {
                                    tag2.t(e2);
                                    return;
                                } else {
                                    tag2.q(Typography.f29117d);
                                    return;
                                }
                            } else if (c2 != '\'') {
                                switch (c2) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.r();
                                        break;
                                    default:
                                        return;
                                }
                            }
                        }
                        tokeniserState = TokeniserState.Data;
                        tokeniser.y(tokeniserState);
                        return;
                    }
                    tokeniser.u(this);
                    tag = tokeniser.f31702i;
                }
                tokeniserState = TokeniserState.BeforeAttributeName;
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            tag = tokeniser.f31702i;
            c2 = 65533;
            tag.q(c2);
        }
    },
    AfterAttributeValue_quoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                if (c2 != '/') {
                    if (c2 == '>') {
                        tokeniser.r();
                    } else if (c2 != 65535) {
                        tokeniser.u(this);
                        characterReader.H();
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.SelfClosingStartTag;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniserState = TokeniserState.BeforeAttributeName;
            tokeniser.y(tokeniserState);
        }
    },
    SelfClosingStartTag {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == '>') {
                tokeniser.f31702i.f31689i = true;
                tokeniser.r();
                tokeniserState = TokeniserState.Data;
            } else if (c2 != 65535) {
                tokeniser.u(this);
                characterReader.H();
                tokeniserState = TokeniserState.BeforeAttributeName;
            } else {
                tokeniser.s(this);
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.y(tokeniserState);
        }
    },
    BogusComment {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.H();
            Token.Comment comment = new Token.Comment();
            comment.f31676c = true;
            comment.f31675b.append(characterReader.k('>'));
            tokeniser.m(comment);
            tokeniser.b(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.t("--")) {
                tokeniser.f();
                tokeniserState = TokeniserState.CommentStart;
            } else if (characterReader.u("DOCTYPE")) {
                tokeniserState = TokeniserState.Doctype;
            } else if (characterReader.t("[CDATA[")) {
                tokeniserState = TokeniserState.CdataSection;
            } else {
                tokeniser.u(this);
                tokeniser.b(TokeniserState.BogusComment);
                return;
            }
            tokeniser.y(tokeniserState);
        }
    },
    CommentStart {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '-') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        tokeniser.f31707n.f31675b.append(c2);
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.p();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.CommentStartDash;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            tokeniser.f31707n.f31675b.append(65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.y(tokeniserState);
        }
    },
    CommentStartDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '-') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        tokeniser.f31707n.f31675b.append(c2);
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.p();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.CommentStartDash;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            tokeniser.f31707n.f31675b.append(65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.y(tokeniserState);
        }
    },
    Comment {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            char q = characterReader.q();
            if (q == 0) {
                tokeniser.u(this);
                characterReader.a();
                tokeniser.f31707n.f31675b.append(65533);
            } else if (q == '-') {
                tokeniser.b(TokeniserState.CommentEndDash);
            } else if (q != 65535) {
                tokeniser.f31707n.f31675b.append(characterReader.m('-', 0));
            } else {
                tokeniser.s(this);
                tokeniser.p();
                tokeniser.y(TokeniserState.Data);
            }
        }
    },
    CommentEndDash {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 == '-') {
                    tokeniserState = TokeniserState.CommentEnd;
                } else if (c2 != 65535) {
                    StringBuilder sb = tokeniser.f31707n.f31675b;
                    sb.append('-');
                    sb.append(c2);
                } else {
                    tokeniser.s(this);
                    tokeniser.p();
                    tokeniserState = TokeniserState.Data;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            StringBuilder sb2 = tokeniser.f31707n.f31675b;
            sb2.append('-');
            sb2.append(65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.y(tokeniserState);
        }
    },
    CommentEnd {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 == '!') {
                    tokeniser.u(this);
                    tokeniserState = TokeniserState.CommentEndBang;
                } else if (c2 != '-') {
                    if (c2 != '>') {
                        if (c2 != 65535) {
                            tokeniser.u(this);
                            StringBuilder sb = tokeniser.f31707n.f31675b;
                            sb.append("--");
                            sb.append(c2);
                        } else {
                            tokeniser.s(this);
                        }
                    }
                    tokeniser.p();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniser.u(this);
                    tokeniser.f31707n.f31675b.append('-');
                    return;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            StringBuilder sb2 = tokeniser.f31707n.f31675b;
            sb2.append("--");
            sb2.append(65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.y(tokeniserState);
        }
    },
    CommentEndBang {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '-') {
                    if (c2 != '>') {
                        if (c2 != 65535) {
                            StringBuilder sb = tokeniser.f31707n.f31675b;
                            sb.append("--!");
                            sb.append(c2);
                        } else {
                            tokeniser.s(this);
                        }
                    }
                    tokeniser.p();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniser.f31707n.f31675b.append("--!");
                    tokeniserState = TokeniserState.CommentEndDash;
                }
                tokeniser.y(tokeniserState);
            }
            tokeniser.u(this);
            StringBuilder sb2 = tokeniser.f31707n.f31675b;
            sb2.append("--!");
            sb2.append(65533);
            tokeniserState = TokeniserState.Comment;
            tokeniser.y(tokeniserState);
        }
    },
    Doctype {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                if (c2 != '>') {
                    if (c2 != 65535) {
                        tokeniser.u(this);
                    } else {
                        tokeniser.s(this);
                    }
                }
                tokeniser.u(this);
                tokeniser.g();
                tokeniser.f31706m.f31681f = true;
                tokeniser.q();
                tokeniserState = TokeniserState.Data;
                tokeniser.y(tokeniserState);
            }
            tokeniserState = TokeniserState.BeforeDoctypeName;
            tokeniser.y(tokeniserState);
        }
    },
    BeforeDoctypeName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            if (characterReader.B()) {
                tokeniser.g();
                tokeniser.y(TokeniserState.DoctypeName);
                return;
            }
            char c2 = characterReader.c();
            if (c2 == 0) {
                tokeniser.u(this);
                tokeniser.g();
                tokeniser.f31706m.f31677b.append(65533);
            } else if (c2 == ' ') {
                return;
            } else {
                if (c2 == 65535) {
                    tokeniser.s(this);
                    tokeniser.g();
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.y(tokeniserState);
                } else if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13) {
                    tokeniser.g();
                    tokeniser.f31706m.f31677b.append(c2);
                } else {
                    return;
                }
            }
            tokeniserState = TokeniserState.DoctypeName;
            tokeniser.y(tokeniserState);
        }
    },
    DoctypeName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            if (characterReader.B()) {
                tokeniser.f31706m.f31677b.append(characterReader.h());
                return;
            }
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != ' ') {
                    if (c2 != '>') {
                        if (c2 == 65535) {
                            tokeniser.s(this);
                            tokeniser.f31706m.f31681f = true;
                        } else if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13)) {
                            sb = tokeniser.f31706m.f31677b;
                        }
                    }
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                    tokeniser.y(tokeniserState);
                    return;
                }
                tokeniserState = TokeniserState.AfterDoctypeName;
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            sb = tokeniser.f31706m.f31677b;
            c2 = 65533;
            sb.append(c2);
        }
    },
    AfterDoctypeName {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            if (characterReader.r()) {
                tokeniser.s(this);
                tokeniser.f31706m.f31681f = true;
                tokeniser.q();
                tokeniser.y(TokeniserState.Data);
            } else if (characterReader.x(9, 10, 13, 12, ' ')) {
                characterReader.a();
            } else {
                if (characterReader.v('>')) {
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    if (characterReader.u(DocumentType.Z2)) {
                        tokeniser.f31706m.f31678c = DocumentType.Z2;
                        tokeniserState2 = TokeniserState.AfterDoctypePublicKeyword;
                    } else if (characterReader.u(DocumentType.a3)) {
                        tokeniser.f31706m.f31678c = DocumentType.a3;
                        tokeniserState2 = TokeniserState.AfterDoctypeSystemKeyword;
                    } else {
                        tokeniser.u(this);
                        tokeniser.f31706m.f31681f = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    }
                    tokeniser.y(tokeniserState2);
                    return;
                }
                tokeniser.b(tokeniserState);
            }
        }
    },
    AfterDoctypePublicKeyword {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypePublicIdentifier;
            } else if (c2 == '\"') {
                tokeniser.u(this);
                tokeniserState = TokeniserState.DoctypePublicIdentifier_doubleQuoted;
            } else if (c2 != '\'') {
                if (c2 == '>') {
                    tokeniser.u(this);
                } else if (c2 != 65535) {
                    tokeniser.u(this);
                    tokeniser.f31706m.f31681f = true;
                    tokeniserState = TokeniserState.BogusDoctype;
                } else {
                    tokeniser.s(this);
                }
                tokeniser.f31706m.f31681f = true;
                tokeniser.q();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.u(this);
                tokeniserState = TokeniserState.DoctypePublicIdentifier_singleQuoted;
            }
            tokeniser.y(tokeniserState);
        }
    },
    BeforeDoctypePublicIdentifier {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13 && c2 != ' ') {
                if (c2 == '\"') {
                    tokeniserState = TokeniserState.DoctypePublicIdentifier_doubleQuoted;
                } else if (c2 != '\'') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        tokeniser.u(this);
                        tokeniser.f31706m.f31681f = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.DoctypePublicIdentifier_singleQuoted;
                }
                tokeniser.y(tokeniserState);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '\"') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        sb = tokeniser.f31706m.f31679d;
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypePublicIdentifier;
                }
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            sb = tokeniser.f31706m.f31679d;
            c2 = 65533;
            sb.append(c2);
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '\'') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        sb = tokeniser.f31706m.f31679d;
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypePublicIdentifier;
                }
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            sb = tokeniser.f31706m.f31679d;
            c2 = 65533;
            sb.append(c2);
        }
    },
    AfterDoctypePublicIdentifier {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
                tokeniserState = TokeniserState.BetweenDoctypePublicAndSystemIdentifiers;
            } else if (c2 == '\"') {
                tokeniser.u(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (c2 != '\'') {
                if (c2 != '>') {
                    if (c2 != 65535) {
                        tokeniser.u(this);
                        tokeniser.f31706m.f31681f = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    } else {
                        tokeniser.s(this);
                        tokeniser.f31706m.f31681f = true;
                    }
                }
                tokeniser.q();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.u(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.y(tokeniserState);
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13 && c2 != ' ') {
                if (c2 == '\"') {
                    tokeniser.u(this);
                    tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
                } else if (c2 != '\'') {
                    if (c2 != '>') {
                        if (c2 != 65535) {
                            tokeniser.u(this);
                            tokeniser.f31706m.f31681f = true;
                            tokeniserState = TokeniserState.BogusDoctype;
                        } else {
                            tokeniser.s(this);
                            tokeniser.f31706m.f31681f = true;
                        }
                    }
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniser.u(this);
                    tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
                }
                tokeniser.y(tokeniserState);
            }
        }
    },
    AfterDoctypeSystemKeyword {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
                tokeniserState = TokeniserState.BeforeDoctypeSystemIdentifier;
            } else if (c2 == '\"') {
                tokeniser.u(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
            } else if (c2 != '\'') {
                if (c2 == '>') {
                    tokeniser.u(this);
                } else if (c2 != 65535) {
                    tokeniser.u(this);
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    return;
                } else {
                    tokeniser.s(this);
                }
                tokeniser.f31706m.f31681f = true;
                tokeniser.q();
                tokeniserState = TokeniserState.Data;
            } else {
                tokeniser.u(this);
                tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
            }
            tokeniser.y(tokeniserState);
        }
    },
    BeforeDoctypeSystemIdentifier {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13 && c2 != ' ') {
                if (c2 == '\"') {
                    tokeniserState = TokeniserState.DoctypeSystemIdentifier_doubleQuoted;
                } else if (c2 != '\'') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        tokeniser.u(this);
                        tokeniser.f31706m.f31681f = true;
                        tokeniserState = TokeniserState.BogusDoctype;
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.DoctypeSystemIdentifier_singleQuoted;
                }
                tokeniser.y(tokeniserState);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '\"') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        sb = tokeniser.f31706m.f31680e;
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypeSystemIdentifier;
                }
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            sb = tokeniser.f31706m.f31680e;
            c2 = 65533;
            sb.append(c2);
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 0) {
                if (c2 != '\'') {
                    if (c2 == '>') {
                        tokeniser.u(this);
                    } else if (c2 != 65535) {
                        sb = tokeniser.f31706m.f31680e;
                    } else {
                        tokeniser.s(this);
                    }
                    tokeniser.f31706m.f31681f = true;
                    tokeniser.q();
                    tokeniserState = TokeniserState.Data;
                } else {
                    tokeniserState = TokeniserState.AfterDoctypeSystemIdentifier;
                }
                tokeniser.y(tokeniserState);
                return;
            }
            tokeniser.u(this);
            sb = tokeniser.f31706m.f31680e;
            c2 = 65533;
            sb.append(c2);
        }
    },
    AfterDoctypeSystemIdentifier {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState tokeniserState;
            char c2 = characterReader.c();
            if (c2 != 9 && c2 != 10 && c2 != 12 && c2 != 13 && c2 != ' ') {
                if (c2 != '>') {
                    if (c2 != 65535) {
                        tokeniser.u(this);
                        tokeniserState = TokeniserState.BogusDoctype;
                        tokeniser.y(tokeniserState);
                    }
                    tokeniser.s(this);
                    tokeniser.f31706m.f31681f = true;
                }
                tokeniser.q();
                tokeniserState = TokeniserState.Data;
                tokeniser.y(tokeniserState);
            }
        }
    },
    BogusDoctype {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            char c2 = characterReader.c();
            if (c2 == '>' || c2 == 65535) {
                tokeniser.q();
                tokeniser.y(TokeniserState.Data);
            }
        }
    },
    CdataSection {
        /* access modifiers changed from: package-private */
        public void n(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.l(characterReader.l("]]>"));
            characterReader.t("]]>");
            tokeniser.y(TokeniserState.Data);
        }
    };
    
    static final char i4 = '\u0000';
    /* access modifiers changed from: private */
    public static final char[] j4 = null;
    /* access modifiers changed from: private */
    public static final char[] k4 = null;
    /* access modifiers changed from: private */
    public static final char[] l4 = null;
    /* access modifiers changed from: private */
    public static final char[] m4 = null;
    private static final char n4 = '�';
    /* access modifiers changed from: private */
    public static final String o4 = null;
    private static final char p4 = '￿';

    static {
        char[] cArr = {'\'', Typography.f29117d, 0};
        j4 = cArr;
        char[] cArr2 = {'\"', Typography.f29117d, 0};
        k4 = cArr2;
        char[] cArr3 = {9, 10, 13, 12, ' ', '/', ASCIIPropertyListParser.f18654l, '>', 0, '\"', '\'', '<'};
        l4 = cArr3;
        char[] cArr4 = {9, 10, 13, 12, ' ', Typography.f29117d, '>', 0, '\"', '\'', '<', ASCIIPropertyListParser.f18654l, '`'};
        m4 = cArr4;
        o4 = String.valueOf(65533);
        Arrays.sort(cArr);
        Arrays.sort(cArr2);
        Arrays.sort(cArr3);
        Arrays.sort(cArr4);
    }

    /* access modifiers changed from: private */
    public static void l(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.B()) {
            String h2 = characterReader.h();
            tokeniser.f31701h.append(h2);
            tokeniser.l(h2);
            return;
        }
        char c2 = characterReader.c();
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ' || c2 == '/' || c2 == '>') {
            if (tokeniser.f31701h.toString().equals(HTML.Tag.A)) {
                tokeniser.y(tokeniserState);
            } else {
                tokeniser.y(tokeniserState2);
            }
            tokeniser.k(c2);
            return;
        }
        characterReader.H();
        tokeniser.y(tokeniserState2);
    }

    /* access modifiers changed from: private */
    public static void m(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        TokeniserState tokeniserState2;
        if (characterReader.B()) {
            String h2 = characterReader.h();
            tokeniser.f31702i.v(h2);
            tokeniser.f31701h.append(h2);
            return;
        }
        if (tokeniser.w() && !characterReader.r()) {
            char c2 = characterReader.c();
            if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
                tokeniserState2 = BeforeAttributeName;
            } else if (c2 == '/') {
                tokeniserState2 = SelfClosingStartTag;
            } else if (c2 != '>') {
                tokeniser.f31701h.append(c2);
            } else {
                tokeniser.r();
                tokeniserState2 = Data;
            }
            tokeniser.y(tokeniserState2);
            return;
        }
        tokeniser.l("</" + tokeniser.f31701h.toString());
        tokeniser.y(tokeniserState);
    }

    /* access modifiers changed from: private */
    public static void o(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] e2 = tokeniser.e((Character) null, false);
        if (e2 == null) {
            tokeniser.k(Typography.f29117d);
        } else {
            tokeniser.o(e2);
        }
        tokeniser.y(tokeniserState);
    }

    /* access modifiers changed from: private */
    public static void p(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char q = characterReader.q();
        if (q == 0) {
            tokeniser.u(tokeniserState);
            characterReader.a();
            tokeniser.k(65533);
        } else if (q == '<') {
            tokeniser.b(tokeniserState2);
        } else if (q != 65535) {
            tokeniser.l(characterReader.m('<', 0));
        } else {
            tokeniser.m(new Token.EOF());
        }
    }

    /* access modifiers changed from: private */
    public static void q(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.B()) {
            tokeniser.h(false);
            tokeniser.y(tokeniserState);
            return;
        }
        tokeniser.l("</");
        tokeniser.y(tokeniserState2);
    }

    /* access modifiers changed from: package-private */
    public abstract void n(Tokeniser tokeniser, CharacterReader characterReader);
}
