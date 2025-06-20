
rangy.init();

            highlighter = rangy.createHighlighter();

            highlighter.addClassApplier(rangy.createCssClassApplier("highlight", {
                ignoreWhiteSpace: true,
                tagNames: ["hl", "a"]
            }));

            highlighter.addClassApplier(rangy.createCssClassApplier("highlightBlue", {
                ignoreWhiteSpace: true,
                tagNames: ["hl", "a"]
            }));
            highlighter.addClassApplier(rangy.createCssClassApplier("highlightYellow", {
                ignoreWhiteSpace: true,
                tagNames: ["hl", "a"]
            }));
            highlighter.addClassApplier(rangy.createCssClassApplier("highlightGreen", {
                ignoreWhiteSpace: true,
                tagNames: ["hl", "a"]
            }));
            highlighter.addClassApplier(rangy.createCssClassApplier("highlightRed", {
                ignoreWhiteSpace: true,
                tagNames: ["hl", "a"]
            }));
            highlighter.addClassApplier(rangy.createCssClassApplier("highlightBanafsh", {
                ignoreWhiteSpace: true,
                tagNames: ["hl", "a"]
            }));
            highlighter.addClassApplier(rangy.createCssClassApplier("highlightNote", {
                ignoreWhiteSpace: true,
                elementTagName: "a",
                elementProperties: {
                    onclick: function() {
                        var highlight = highlighter.getHighlightForElement(this);
                        var h = highlight;
                        var sep = 'soheilvbsoheilvbsoheilvb';

                        var location = 'note://'+h.characterRange.start+sep+h.characterRange.end+sep+h.id+sep+h.classApplier.cssClass+sep;

                        window.location =  location;
                        return false;
                    }
                }

            }));

            highlighter.addClassApplier(rangy.createCssClassApplier("note", {
                ignoreWhiteSpace: true,
                elementTagName: "a",
                elementProperties: {
                    href: "#",
                    onclick: function() {
                        var highlight = highlighter.getHighlightForElement(this);
                        
                      //  if (window.confirm("Delete this note (ID " + highlight.id + ")?")) {
                      //      highlighter.removeHighlights( [highlight] );
                      //  }
                      var h= highlight;
                      window.location.href = 'note://'+h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$';
                        return false;
                    }
                }
            }));
            


        function gotoHighlight(save) {


            for (var i = 0, len = highlighter.highlights.length; i < len; ++i) {
                var h=highlighter.highlights[i];
                var hs=h.characterRange.start+'$'+h.characterRange.end+'$'+h.id+'$'+h.classApplier.cssClass+'$';

                if (hs==save) {
                    console.log("LogAction,,,,," + h.getHighlightElements().length);
                    h.getHighlightElements()[0].scrollIntoView(true);
                }
            }


        }

            

        function noteSelectedText() {
            s=highlighter.highlightSelection("note");
            return s[0];
        }
        
        function highlightSelectedText() {
            s=highlighter.highlightSelection("highlight");
            return s[0];
        }

        function highlightSelectedTextWithClass(classtoapply) {
                    s=highlighter.highlightSelection(classtoapply);
                    return s[0];
        }

        function removeHighlightFromSelectedText() {
            return highlighter.unhighlightSelection()[0];
        }

        function highlightScopedSelectedText() {
            highlighter.highlightSelection("highlight", null, "summary");
        }

        function noteScopedSelectedText() {
            highlighter.highlightSelection("note", null, "summary");
        }

        function reloadPage(button) {
            button.form.elements["serializedHighlights"].value = highlighter.serialize();
            button.form.submit();
        }

        function getRect(width, height){
           var allSelections = window.getSelection();
           var aRange = allSelections.getRangeAt(0);
           var rects = aRange.getClientRects();
           var rect = rects[0];
           rect = aRange.getBoundingClientRect();


           var x = rect.left;
           var y = rect.top;


           console.log("coordinates,,,,," + x + ",,,,," + y + ",,,,," + window.innerWidth + ",,,,," + window.innerHeight);

        }

