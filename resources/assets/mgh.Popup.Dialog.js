
jQuery(function ($) {

});


$(document).ready(function(){
    PopupDialogContent();
});

function PopupDialogContent() {
    /********************************************/
    /*      Default Dialog Popup Settings  -- MGH   */
    /********************************************/
    var dialogOptions = {
        autoOpen: false,
        width: 750,
        height: 600,
        closeText: "[ X ] Close",
        modal: true,
        zIndex: 9999,
        dialogClass: 'absolute-dialog'
    };


    $('.ChapterRefNew').click(function (e) {
        document.location.href='contentref://' + $(this).attr('href') + '&';

    });

    /*Print this option in figure and table dialog*/
    $('.printThis').live('click', function (e) {
        e.preventDefault();
        var printWindow;
        if ($(this).parent().hasClass('widget-buttons')) {
            if ($(this).parent().siblings().hasClass('figureSection')) {
                printWindow = buildpage(this, '.fancybox-inner', '.figureSection', false);
            } else {
                printWindow = buildpage(this, '.fancybox-inner', '.tableContainer', false);
            }

        } else {
             printWindow = buildpage(this, '.ui-dialog', '.ui-dialog-content', false);
        }
        openPrintWindow(printWindow, true);
    });
    var registeredDialogs = [];
    //Creates a popup Dialog
    '.popUpFigure', '.figureDialog'
    function createPopupDialog(linkSelector, dialogSelector, extendOptions) {
        $(linkSelector).each(function () {

            $(this).click(function (e) {
                e.preventDefault();
                var $popupDialog = $(this).siblings(dialogSelector); // associate to table dialog
                if ($popupDialog.length !== 0) {
                    registerDialog(this, $popupDialog);
                }
                else {
                    $popupDialog = getDialog1(dialogSelector);
                }
                var tmpOptions = {};
                $.extend(tmpOptions, dialogOptions, extendOptions); // extend options
                $(dialogSelector).dialog(tmpOptions); // create table dialog modals
                $('#copyrightID').append($(document).find('#Form1').find('.disclosures .copyrightInfo:first').clone());

                $popupDialog.dialog('open');
                // The dialog might set focus to an item at the bottom of the content, so set focus to the close button.
                $popupDialog.parent().find('.ui-dialog-titlebar button:eq(0)').focus();
                // In case the dialog set focus to an item at the bottom of the content, scroll back up to the top.
                $popupDialog.scrollTop(0);

                if (linkSelector == '.popUpFigure') {
                    var downloadPPTLink = $(this).siblings('.downloadSlide').attr('href');
                    var savethis = $(this).siblings('.saveMyStuffs').clone();
                    var newLink;
                    if (window.location.pathname == '/account/myalerts.aspx') {
                    //    newLink = '<a href="' + downloadPPTLink + '" class="downloadThis">Download Slide (.ppt)</a>&#160;&#124;&#160;<a class="printThis">Print</a>';
                    } else {
                     //   newLink = '&#160;&#124;&#160;<a href="' + downloadPPTLink + '" class="downloadThis">Download Slide (.ppt)</a>&#160;&#124;&#160;<a class="printThis">Print</a>';
                    }

                    $popupDialog.parents('.ui-dialog').find('.ui-dialog-title').empty().append(savethis);
                    $popupDialog.parents('.ui-dialog').find('.ui-dialog-title').append(newLink);
                    // RHM 06.17.13 - Force figure in dialog to load
                    imgSrc = $popupDialog.children('img').data('original');
                    $popupDialog.children('img').attr('src', imgSrc);

                    //Stats Tracking
                    //DoClientTrackingForMGH($(this), 'sectionId=' + $(this).next('a').attr('id'), linkSelector.replace('.', ''));
                }
                else if (linkSelector == '.popUpTable') {
                    var savethis = $(this).siblings('.saveMyStuffs').clone();
                    $popupDialog.parents('.ui-dialog').find('.ui-dialog-title').empty().append(savethis);
                    var newLink;
                    if (window.location.pathname == '/account/myalerts.aspx') {
                   //     newLink = '<a class="printThis">Print</a>';
                    } else {
                    //    newLink = '&#160;&#124;&#160;<a class="printThis">Print</a>';
                    }

                    $popupDialog.parents('.ui-dialog').find('.ui-dialog-title').append(newLink);
                    // Force figure in dialog to load
                    $popupDialog.find('img').each(function () {
                        var imgSrc = $(this).data('original');
                        $(this).attr('src', imgSrc);
                    });

                    //Stats Tracking
                    //DoClientTrackingForMGH($(this), 'sectionId=' + $(this).next('a').attr('id'), linkSelector.replace('.', ''));
                } else {
                    createDialogTitle(dialogSelector);

                    //Stats Tracking
                    //DoClientTrackingForMGH($(this), linkSelector.replace('.', ''), linkSelector.replace('.', ''));
                }
            });

            function registerDialog(link, dialogDiv) {
                var linkId = link; // $(link).attr("id");
                if (!registeredDialogs[linkId])
                    registeredDialogs[linkId] = dialogDiv;
            }

            function getDialog1(link) {
                var linkId = link; // $(link).attr("id");
                return $('.ui-dialog').find(link);
            }


        });


    }

    /*add Title to popup*/
    function createDialogTitle(thisDialog) {
        var uiDialogTitle = $(thisDialog).siblings('.ui-dialog-titlebar').find('.ui-dialog-title');

        switch (thisDialog) {
            case '.emailPopupDialog':
                var emailDialogTitle = 'Send Email';
                uiDialogTitle.empty().prepend(emailDialogTitle);
                break;
            case '.recommendDialog':
                var recommendDialogTitle = 'Recommend Now';
                uiDialogTitle.empty().append(recommendDialogTitle);
                break;
            case '.getCitationPopupDialog':
                uiDialogTitle.empty().prepend('Get Citation');
                break;
            case 'searchAlertPopupDialog':
                uiDialogTitle.empty().prepend('Search Alerts');
                break;
            case '.alertPopupDialogCollection':
            case '.alertPopupDialog':
            case '#issueAlertPopupDialog':
            case '#onlineFirstAlertPopupDialog':
                uiDialogTitle.empty().prepend('User Alerts');
                break;
        }

        //$(thisDialog).append($(document).find('#Form1').clone());
        //  $(document).find('#Form1').append($(thisDialog));
        $(thisDialog).parent().appendTo($('#Form1'));
    }

    //-------------------------------------------------------------------------------------------------
    // VARIOUS POPUPS
    //-------------------------------------------------------------------------------------------------
    /*Table Dialog*/
    $('.popUpTable').live('click', function (e) {
        // verify autehentication of the user
        // alert("AUTHENTICATE HERE");

         isAuthenticated = true;


        if (isAuthenticated) {
            e.preventDefault();

            var $popupDialog = $(this).siblings('.tableDialog'); // find the dialog

            var $name = $popupDialog.parent().parent().parent().children('a').attr("name");
            $popupDialog.attr("id",'tableDialog'+$name);
            // add content for the dialog, if it doesn't already exist.
            if ($popupDialog.find(".widget-buttons").length == 0) {
                var savethis = $(this).siblings('.saveMyStuffs').clone();
                savethis.addClass('btn');
                savethis.prepend('<i class="icon-bookmark icon-white"><i>');

            //    var newLink = '<a class="printThis btn"><i class="icon-print icon-white"></i>Print</a>';
            //    $popupDialog.prepend("<div class='widget-buttons'></div>");
            //    $popupDialog.find(">:first-child").append(savethis);
            //    $popupDialog.find(">:first-child").append(newLink);
            }

            $.fancybox({
                'autoScale': false,
                'autoDimensions': false,
                'maxWidth': 750,
                'transitionIn': 'fade',
                'transitionOut': 'fade',
                'scrolling': 'auto',
                'autoSize': true,
                'titlePosition': 'over',
                'href': '#' + $popupDialog.attr('id')
            });

        }
    });

    /*Figure Dialog*/
    $('.popUpFigure').on('click', function (e) {
        // verify autehentication of the user
        // alert("AUTHENTICATE HERE");
        var isAuthenticated = true;
        var pathname = window.location.pathname;



        if (isAuthenticated) {
            e.preventDefault();
            var $popupDialog = $(this).siblings('.figureDialog'); // find the dialog

            // add content for the dialog, if it doesn't already exist.
            if ($popupDialog.find(".widget-buttons").length == 0) {
                //Force Lazy load
                var imgSrc = $popupDialog.children('.figureSection').children('img').data('original');
                $popupDialog.children('.figureSection').children('img').attr('src', imgSrc);

                // RHM 06.17.13 - Force figure in dialog to load
                imgSrc = $popupDialog.children('img').data('original');
                $popupDialog.children('img').attr('src', imgSrc);

                //add the figure title
                $popupDialog.prepend($popupDialog.parent().parent().parent().children('h6:eq(0)').clone());
                //add the figure legend
                $popupDialog.append($popupDialog.parent().parent().parent().children('p').clone());

                var downloadPPTLink = $(this).siblings('.downloadSlide').attr('href');
                var savethis = $(this).siblings('.saveMyStuffs').clone();
                savethis.addClass('btn');
                savethis.prepend('<i class="icon-bookmark icon-white"></i>');

                var newLink;
                if (window.location.pathname == '/account/myalerts.aspx') {
                 //   newLink = '<a href="' + downloadPPTLink + '" class="downloadThis btn"><i class="icon-circle-arrow-down icon-white"></i>Download Slide (.ppt)</a><a class="printThis btn"><i class="icon-print icon-white"></i>Print</a>';
                } else {
                    //newLink = '<a href="' + downloadPPTLink + '" class="downloadThis btn"><i class="icon-circle-arrow-down icon-white"></i>Download Slide (.ppt)</a><a class="printThis btn"><i class="icon-print icon-white"></i>Print</a>';
                }
                $popupDialog.prepend("<div class='widget-buttons'></div>");
                $popupDialog.find(">:first-child").append(savethis);
                $popupDialog.find(">:first-child").append(newLink);
            }

            document.location.href='svb://' + $popupDialog.attr('id');
            return ;
            $.fancybox({
                'autoScale': false,
                'autoDimensions': false,
                'maxWidth': 550,
                'transitionIn': 'fade',
                'transitionOut': 'fade',
                'scrolling': 'auto',
                'autoSize': true,
                'titlePosition': 'over',
                'href': '#' + $popupDialog.attr('id'),
                onUpdate: function () {
                    $.fancybox.update();
                }
            });

            //Stats Tracking
            //DoClientTrackingForMGH($(this), 'sectionId=' + $(this).next('a').attr('id'), 'popUpFigure');
        }
    });

    function fancypopupforLogin(url, autosize, Height, Width) {

        $.fancybox({
            'autoScale': false,
            'autoDimensions': false,
            'transitionIn': 'fade',
            'transitionOut': 'fade',
            'type': 'iframe',
            'scrolling': 'auto',
            'titlePosition': 'over',
            'href': url,
            'maxWidth': Width,
            'width': Width,
            'height': Height,
            'onComplete': function () {
                $('.fancybox-inner').css('width', 20);
                $('.fancybox-wrap').css('width', 40);
                $('.fancybox-skin').css('width', 40);
            }
        });
    }

    // This is not needed for MGH since we donot have tab2
    //    if ($('#tab2').find('.popUpFigure').length) {
    //        createPopupDialog('.popUpFigure', '.figureDialog', { modal: false });
    //    } else if ($("#showImageCarousel").length) {

    //        var figureRotator = $('.rotatorFigLink'), figureRotatorCount = figureRotator.length;
    //        figureRotator.each(function (i) {
    //            $(this).siblings('.rotatorFigLinkDialog').prepend("<br /><br />").prepend($("img", this).clone());
    //            if (! --figureRotatorCount) createPopupDialog('.rotatorFigLink', '.rotatorFigLinkDialog');
    //        });
    //    }

    /*Recomment this form dialog*/ // not need for MGH at this point of time.
    /*  createPopupDialog('.recommendThis', '.recommendDialog', {
    open: function () {
    $('.recommendDialog').css('height', '450px');
    }
    });*/

    /*My account - edit passowrd popup*/
    $('.editPasswordButton').click(function () {
        $('.editPasswordDialog').dialog({
            width: 400,
            open: function () {
                $('.editPasswordDialog').css('height', 'auto');
                $(".cancelButton").live("click", function () {
                    $(this).dialog('close');
                });
            },
            buttons: {
                "Edit Password": function () {
                    $('#<%=btnUpdatePassword.ClientID%>').attr(); //.trigger('click');
                },
                "Cancel": function () {
                    $(this).dialog('close');
                }
            },
            modal: true,
            overlay: { opacity: 0.7, background: 'gray' }
        });
    });


    /*======================================================================================================*/
    /*                                              ALERT MODEL                                             */
    /*======================================================================================================*/

    /****************************************************/
    /*      EMAIL ALERTS: USER PERSONALIZATION      */
    /****************************************************/
    var showAlertModal = false;
    //var showIssueModel = false;
    var showOnlineFirstModel = false;
    //var showCollectionModel = false;

    // Beginning of Toolbox Feature: User Alerts
    showAlertModal = ($("#hfAlerts").val() == "1") ? true : false;
    if (showAlertModal) {
        createPopupDialog('.showAlerts', '.alertPopupDialog', {
            open: function () {
                //$(this).parents('.ui-dialog').find('.ui-dialog-title').html('User Alerts');
                $('.alertPopupDialog').css({ "min-height": "200px", "min-width": "400px", "height": "auto", "width": "auto" });
                $('#progressBar').hide();
            }
        });
    }
    else {
        $('.showAlerts').click(function () {
            var alertMode = $("#hfAlerts").val();
            displaySignInDialog(alertMode);
            //openSignInPopup();
        });
    }
    //showOnlineFirstAlerts Starts. uncomment this when online first is needed
    /* showOnlineFirstModel = ($("#hfOnlineFirstAlerts").val() == "1") ? true : false;
    if (showOnlineFirstModel) {
    createPopupDialog('.showOnlineFirstAlerts', '.alertPopupDialog', {
    open: function () {
    //$(this).parents('.ui-dialog').find('.ui-dialog-title').html('User Alerts');
    $('.alertPopupDialog').css({ "min-height": "200px", "min-width": "400px", "height": "auto", "width": "auto" });
    $('#progressBar').hide();
    }
    });
    }
    else {
    $('.showOnlineFirstAlerts').click(function () {
    var alertMode = $("#hfOnlineFirstAlerts").val();
    displaySignInDialog(alertMode);
    //openSignInPopup();
    });
    } */
    //showOnlineFirstAlerts Ends
    /****************************************************/
    /*      TOOLBOX FEATURES: USER PERSONALIZATION      */
    /****************************************************/

    var showGetCitationModal = false;
    var showSendEmailModal = false;
    var showShareThisModal = false;
    var showSearchAlertModal = false;
    var showDataSupplementModal = false;
    var showSlideset = false;
    var showPDFDownload = false;
    // Beginning of Toolbox Feature: Get Citation
    showGetCitationModal = ($("#hfGetCitation").val() == "1") ? true : false;
    if (showGetCitationModal) {
        $('.aGetCitation').click(function (e) {
            e.preventDefault();
            $.fancybox({
                'autoScale': false,
                'autoDimensions': false,
                'maxWidth': 550,
                'transitionIn': 'fade',
                'transitionOut': 'fade',
                'scrolling': 'auto',
                'autoSize': true,
                'titlePosition': 'over',
                'href': '#getCitationPopupDialog'
            });
            //Stats Tracking
            //DoClientTrackingForMGH($(this), 'getCitationPopupDialog', 'getCitationPopupDialog');
            //hide empty citagin tags
            if ($.trim($('.copyPaste').find('span.editor').find('.apacitation').html()).length == 0) {
                $('.copyPaste').find('span.editor').hide();
            }
            $('div.amacitation').find('.apacitation').hide();
            $('div.apacitation').find('.amacitation').hide();
        });
    }
    else {
        $('.aGetCitation').click(function () {
            //var getCitationMode = $("#hfGetCitation").val();
            //displaySignInDialog(getCitationMode);
            fancysigninpopup('/signin.aspx?redirectUrl=' + (window.location).toString(), '', 'false');
        });
    }
    // End of Toolbox Feature: Get Citation

    // Beginning of Toolbox Feature: Send Email
    showSendEmailModal = ($("#hfEmail").val() == "1") ? true : false;

    if (showSendEmailModal) {
        $('.sendEmail').click(function (e) {
            e.preventDefault();
            $.fancybox({
                'autoScale': false,
                'autoDimensions': false,
                'transitionIn': 'fade',
                'transitionOut': 'fade',
                'scrolling': 'auto',
                'autoSize': true,
                'titlePosition': 'over',
                'href': '#emailPopupDialog'
            });
            //Stats Tracking
            //DoClientTrackingForMGH($(this), 'emailPopupDialog', 'emailPopupDialog');
        });
    }
    else {
        $('.sendEmail').click(function () {
            //var emailMode = $("#hfEmail").val();
            //displaySignInDialog(emailMode);
            fancysigninpopup('/signin.aspx?redirectUrl=' + (window.location).toString(), '', 'false');
        });
    }
    // End of Toolbox Feature: Send Email

    // Beginning of Toolbox Feature: Share This
    showShareThisModal = ($("#hfShareThis").val() == "1") ? true : false;
    if (showShareThisModal) {
        // TODO: What to do? Unknown at this point!
    }
    else {
        $('.shareThis').click(function () {
            var shareThisMode = $("#hfShareThis").val();
            displaySignInDialog(shareThisMode);
        });
    }
    // End of Toolbox Feature: Share This

    // Beginning of Toolbox Feature: Show dataSupplement
    showDataSupplementModal = ($("#hfDataSupplement").val() == "1") ? true : false;
    articleId = $("#hfArticleId").val();
    if (showDataSupplementModal) {
        createPopupDialog('.dataSupplementLink', '.dataSupplementDialog', {
            open: function () {
                //$(this).parents('.ui-dialog').find('.ui-dialog-title').html('Data Supplement');
                $(this).parent().appendTo("form");
                $('.dataSupplementDialog').css('height', 'auto');

                var currDialog = $(this);
                $(".closeDialog", this).live("click", function (e) {
                    e.preventDefault();
                    currDialog.dialog('close');
                });
            }
        });
    }
    else {
        $('.dataSupplementLink').click(function () {
            var dataSupplementMode = $("#hfDataSupplement").val();
            displaySignInDialog(dataSupplementMode);
        });
    }
    // End of Toolbox Feature: Show DataSupplement

    // Beginning of Toolbox Feature: Show Slideset
    showSlideset = ($("#hfSlideset").val() == "1") ? true : false;
    if (showSlideset) {
        // TODO:
    }
    else {
        $('.slideset').click(function () {
            var slideSetMode = $("#hfSlideset").val();
            displaySignInDialog(slideSetMode);
        });
    }
    // End of Toolbox Feature: Show Slideset

    // Begin of PDF Download
    showPDFDownload = ($("#hfPDFDownload").val() == "1") ? true : false;
    if (!showPDFDownload) {
        $('.linkPDF').click(function () {
            var articlePDFMode = $("#hfPDFDownload").val();
            displaySignInDialog(articlePDFMode);

            return false;
        });
    }
    //-------------------------------------------------------------------------------------------------
    // Display Sign In Dialog with appropriate content.
    //-------------------------------------------------------------------------------------------------
    function displaySignInDialog(mode) {

        if (mode == "MustSignInOrBuyThisArticle") {
            $('#globalSignIn11_PurchaseSubscription').show()
            $('#globalSignIn11_PersonalAccountRegistration').hide()
        }

        if (mode == "MustSignInOrRegisterForFreeAccount") {
            $('#globalSignIn11_PurchaseSubscription').hide()
            $('#globalSignIn11_PersonalAccountRegistration').show()
        }


        $('#globalSignIn3').dialog({
            closeText: "[ X ] Close",
            width: 665,
            height: 367,
            title: "Sign In",
            modal: true,
            overlay: { opacity: 0.7, background: 'gray' }
        });
        $('#globalSignIn3').parent().appendTo($('#Form1'));
    }

    //-------------------------------------------------------------------------------------------------
    /*===============================================================================================*/
    /**                     Prints Article page and Book Content Page Section                       **/
    /**                  Print is unlike the rest because it opens a new window                     **/
    /*===============================================================================================*/

    $('.aPrintArticle').click(function () {

        printableView = ($("#hfPrintableView").val() == "1") ? true : false;
        if (printableView) {
            $("div.contentContainer").hide();
            $(".tabNav div a").removeClass("selected");
            $(".tabNav .atab:nth-child(1) a").addClass("selected").show();
            $("#tab1").show();
            var pageContent = buildpage(this, '.container', '.contentSectionTab');     //build html page
            openPrintWindow(pageContent, false);

            //Stats Tracking
            //DoClientTrackingForMGH($(this), 'Print', 'Print');
        }
        else {
//            var printMode = $("#hfPrintableView").val();
            //            displaySignInDialog(printMode);
            fancysigninpopup('/signin.aspx?redirectUrl=' + (window.location).toString(), '', 'false');
        }
    });

    function buildpage(selector, parentSelector, findContent, loop) {
        var content = $(selector).parents(parentSelector).find(findContent).clone();
        var loop = (loop == undefined) ? true : loop;
        var contentHeader = $('.page-header').clone();
        var journalName = $(contentHeader).children('.journalName').text();         //JOURNAL NAME
        //var pageWrapper = $('.pageContentHolder').find('.wrapper').attr('class');   //Options: Article = articlePage, Book = contentPage
        var pageWrapper = "";
        if ($('.container').parents('.article').length > 0) {
            pageWrapper = "articlePage";
        } else if ($('.container').parents('.content').length > 0) {
            pageWrapper = "contentPage";
        }

        var html = "";
        html += printMastHead(journalName, pageWrapper);
        html += printHeader(journalName, contentHeader);
        html += printContentBody(loop, content, pageWrapper);
        html += printFooter(selector, pageWrapper);

        return html;
    }

    function printMastHead(journalName, pageWrapper) {
        var html = "";
        //html += '<link href="CSS/global.css" type="text/css" rel="stylesheet"/>';
        // html += '<link href="CSS/global.less" type="text/css" rel="stylesheet"/>';
        if (journalName == 'PN') {
            //    html += '<link href="CSS/newsArticle.css" type="text/css" rel="stylesheet"/>';
            //    html += '<link href="CSS/PN/pn.news.print.css" type="text/css" rel="stylesheet"/>';
        } else {
            //    html += '<link href="CSS/content.css" type="text/css" rel="stylesheet"/>';
            //            var clonedArray = $.map($("link[rel='Stylesheet']"), function (obj) {
            //                return $.extend({}, obj);
            //            });


            var toPrint = $("link[rel='stylesheet']").clone();

            if (toPrint.html()) {
                html += $('<link href="aaaaaaaaaaaaa" type="css" rel="stylesheet"/>').append(toPrint.clone()).html();
            }

            // This for chrome when link is not copied. get one css with sitename
            if (html == "") {
                html += toPrint[0].outerHTML;
                html += toPrint[1].outerHTML;
            }
            //html += '<link href="CSS/plugins/scm6.popUpDialog.css" type="text/css" rel="stylesheet"/>';
        }

        html += '<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>';
        html += '<script type="text/javascript" language="javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.js"></script>';
        html += "<script type='text/javascript'>$(document).ready(function () { var el = $('#microsite-masthead a'); el.html('<img src=' + el.css('background-image').slice(4, -1) + '>').css('text-indent', 0);}); </script>";


        //  html += '<script type="text/javascript" language="javascript" src="JS/ads.js"></script>';
        html += '</head><br><body class="printPage"><div class="printPage"/>';

        if (pageWrapper == 'articlePage') {
            html += '<div id="printHeader"><div class="journal"><a id="siteLogo" class="sprite-logos ir" href="/">[CHEST Journal]</a></div></div>';
            html += '<div class="clearAll"></div>';
        }


        if (pageWrapper == 'contentPage') {
            html += $('<div id="printHeader"><div class="books journal">').append($('#microsite-masthead').clone()).html();
            //  html += $('#microsite-masthead').html();
            html += '</div></div>';
            html += '<div class="clearAll"></div>';
        }






        return html;
    }

    function printHeader(journalName, contentHeader) {
        var html = "";
        var thisWidth = '720';
        var toPrint = $(contentHeader).children('.contentSection').clone();     //Article Type, Article Date
        html += $('<div id="printPage"/>').append(toPrint).html();

        toPrint = $('.chapInformation .chapTitle  .aBookPath').find('span').clone(); ///BOOK Name
        html += $('<div id="printPage"/>').append(toPrint).html();

        toPrint = $(contentHeader).find('h1').clone();              //Article Title
        // toPrint = $(contentHeader).find('.chapTitle').clone();
        // Sometimes the Title is floated to the right (like for books) and ends up making the print page look funny.
        // So, overriding that attribute.
        $(toPrint).css({ 'float': 'none', 'width': thisWidth });
        html += $('<div id="printPage"/>').append(toPrint).html();
        toPrint = $(contentHeader).find('.chapTitle').clone();
        html += $('<div id="printPage"/>').append(toPrint).html();


        toPrint = $(contentHeader).find('.authorSectionBold').clone();  //Article Author
        html += $('<div id="printPage"/>').append(toPrint).html();

        toPrint = $(contentHeader).find('.authorSection').clone();      //Article Author
        html += $('<div id="printPage"/>').append(toPrint).html();

        toPrint = $('.disclosureText .para').clone().css('border', 'none');       // disclosure content
        html += $('<div id="printPage"/>').append(toPrint).html();

        toPrint = $(contentHeader).find('.aShortDesc').clone();         //Article short description
        html += $('<div id="printPage"/>').append(toPrint).append('<br/>').html();

        return html;
    }
    function printContentBody(loop, content, pageWrapper) {
        var contentBody = $(content).clone();                             //CONTENT BODY
        var commentSection = $(content).find('.comments').clone();        //CONTENT SECTION
        var tableIndex = 0;
        var tableDialog = $('.ui-dialog').find('.tableDialog');
        var html = "";

        //For Psychiatric News - Abstract-teaser
        var absTeaser = $('.abstract-teaser').clone();
        html += $('<div id="printPage"/>').append(absTeaser).html();

        //Looping through all section of Article Tab
        if (loop) {
            $(contentBody).each(function () {
                var sectionTitle = $(this).find('.contentJump').find('h2').clone();
                html += $('<div id="printPage"/>').append(sectionTitle).html();

                //Loop until there is contentBody Section; includes all the content sections
                $(this).find('.contentBody').each(function () {
                    //Setup for article page
                    if (pageWrapper == 'articlePage') {
                        var myChildren = $(this).children();
                        var wrapperClass = $(this).attr('class');

                        if ((wrapperClass == 'contentBody figureSection clearfix') || (wrapperClass == 'contentBody tableSection clearfix')) {
                            var printArticleSection = printContentSection(this, wrapperClass, tableDialog, tableIndex);
                            html += $('<div id="printPage"/>').append('<p/>').append(printArticleSection).html();
                            if (wrapperClass == 'contentBody tableSection') tableIndex++;
                        } else {
                            $(myChildren).each(function () {
                                var wrapperClass = $(this).attr('class');
                                var printArticleSection = printContentSection(this, wrapperClass, tableDialog, tableIndex);
                                html += $('<div id="printPage"/>').append('<p/>').append(printArticleSection).html();
                                if (wrapperClass == 'contentBody tableSection') tableIndex++;
                            });
                        }
                    }

                    //Setup for book content page
                    if (pageWrapper == 'contentPage') {
                        $(this).find('.contentSection').each(function () {

                            var myChildren = $(this).children();
                            var wrapperClass = $(this).attr('class');

                            if ((wrapperClass == 'contentBody figureSection clearfix') || (wrapperClass == 'contentBody tableSection clearfix')) {
                                var printArticleSection = printContentSection(this, wrapperClass, tableDialog, tableIndex);
                                html += $('<div id="printPage"/>').append('<p/>').append(printArticleSection).html();
                                if (wrapperClass == 'contentBody tableSection clearfix') tableIndex++;
                            } else {
                                $(myChildren).each(function () {
                                    if ((wrapperClass == 'contentBody figureSection clearfix') || (wrapperClass == 'contentBody tableSection clearfix')) {
                                        var printArticleSection = printContentSection(this, wrapperClass, tableDialog, tableIndex);
                                        html += $('<div id="printPage"/>').append('<p/>').append(printArticleSection).html();
                                        if (wrapperClass == 'contentBody tableSection clearfix') tableIndex++;
                                    } else {


                                        var wrapperClass = $(this).attr('class');
                                        var printArticleSection = printContentSection(this, wrapperClass, tableDialog, tableIndex);
                                        html += $('<div id="printPage"/>').append('<p/>').append(printArticleSection).html();
                                        if (wrapperClass == 'contentBody tableSection clearfix') tableIndex++;
                                    }

                                });
                            }
                        });
                    }

                });
            });

            //commentsTab
            if ($(commentSection)[0] != undefined && $.trim($(commentSection)[0].innerHTML) != '') {
                html += '<h2>User Comments</h2>';
                html += $('<div id="printPage"/>').append(commentSection).html();
            }
        } else {
            html += $('<div id="printPage"/>').append(content.css('height', 'auto')).html();
        }

        return html;
    }

    function multiReplace(str, match, repl) {
        do {
            str = str.replace(match, repl);
        } while (str.indexOf(match) !== -1);
        return str;
    }
    function singleReplace(str, match, repl) {
        str = str.replace(match, repl);
        return str;
    }
    //Print all the contentSections from contentSectionTab
    function printContentSection(sel, myclass, tableDialog, tableIndex) {
        var thisSection;
        if (myclass == 'contentBody figureSection clearfix') {
            thisSection = $('<div id="printPage"/>').append('<p/>').append($(sel).find('.inlineFigure').html()).html();
            //  thisSection += $('<div id="printPage"/>').append($(sel).find('.inlineFigure').children('.figureLegend').clone()).html();
            // thisSection += $('<div id="printPage"/>').append('<p/>').append($(sel).find('.contentFigures').clone()).html()

            $(sel).find('.figureLinks').each(function () {
                var $figureLinks = $(this);
                var figuredialog = $figureLinks.html();
                thisSection = multiReplace(thisSection, figuredialog, "");
            });

            $(sel).find('.inlineFigureImageContainer').each(function () {
                var $figimagecontainer = $(this);
                var originalFigurePath = $figimagecontainer.children('img').data('original');
                var spinnerPath = $figimagecontainer.children('img').attr('src');

                if (originalFigurePath != spinnerPath) {
                    thisSection = singleReplace(thisSection, spinnerPath, originalFigurePath);
                }

            });

            thisSection = multiReplace(thisSection, "/s_", "/");
        } else if (myclass == 'contentBody tableSection clearfix') {
            // var tableContainer = $(tableDialog)[tableIndex].innerHTML;
            //  thisSection = $(tableContainer).clone();
            thisSection = $('<div id="printPage"/>').append('<p/>').append($(sel).find('.inlineFigure').find('.tableContainer').clone()).html();
        } else {

            thisSection = $(sel).clone().html();

            $(sel).find('.inlineFigureImageContainer').each(function () {
                var $figimagecontainer = $(this);
                var originalFigurePath = $figimagecontainer.children('img').data('original');
                var spinnerPath = $figimagecontainer.children('img').attr('src');

                if (originalFigurePath != spinnerPath) {
                    thisSection = singleReplace(thisSection, spinnerPath, originalFigurePath);
                }

            });


        }

        return thisSection;
    }

    function printFooter(selector, pageWrapper) {
        var html = "";
        var currentYear = (new Date).getFullYear();
        var toPrint = $(selector).parents('.webform').find('#umbrella-footer').clone(); //copyright information

        if (toPrint.length == 0) {
            html += '<div class="copyrightInfo">Copyright © ' + currentYear + ' The McGraw-Hill Companies.   All rights reserved.</div>';
        } else {
            html += $('<div id="printPage"/>').append(toPrint).html();
        }

        html += '<div class="clearAll"></div>';

        return html;
    }

    //opens the print dialog
    function openPrintWindow(html, bool) {
        var w = 760;
        var h = 400;
        var left = (screen.width / 2) - (w / 2);
        var top = (screen.height / 2) - (h / 2);

        var tblWindow = window.open('', 'Table', 'width=' + w + ', height=' + h + ', scrollbars=1, resizable=1, top=' + top + ', left=' + left);

        tblWindow.document.open();
        tblWindow.document.write(html);
        tblWindow.document.close();

        tblWindow.print();
        if (!$.browser.webkit) { // protect against CHROME crash when canceling print dialog
            // if (closeMe == true) tblWindow.close();
        }
    }


    //    function openSignInPopup() {
    //        var w = 650;
    //        var h = 350;
    //        var left = (screen.width / 2) - (w / 2);
    //        var top = (screen.height / 2) - (h / 2);
    //        var popupParms = ',top=' + top + ',left=' + left;

    //        var accessMode = $("#hfAlerts").val();
    //        var articleID = $("#hfArticleId").val();

    //        if (accessMode != null) url = "../signinpopup.aspx?accessMode=" + accessMode + "&articleID=" + articleID;
    //        else url = "../signinpopup.aspx";

    //        window.open(url, "mywindow", "menubar=0,resizable=0,width=650,height=350" + popupParms);
    //    };

    //    function signInDialogInitialize() {
    //        alert('Test init');
    //        $('#printTool, #hlPDFlink, #alertTool, #toolComment, #aSlideSet').click(function () {
    //                $('.signinDialog').dialog({
    //                    closeText: "X Close",
    ////                    width: 350,
    ////                    height: 110
    //                });
    //                alert('Test click');
    //            });
    //    }

    //Committment to change dialog
    $('#committment').click(function (e) {
        e.preventDefault();
        $('#committmentDialog').dialog({
            closeText: "[ X ] Close",
            width: 735,
            height: 425,
            title: "Commitment to Change",
            modal: true,
            overlay: { opacity: 0.7, background: 'gray' }
        });
        $('#committmentDialog').parent().appendTo($('#Form1'));
    });
    $('#submit').click(function () {
        $('#committmentDialog').dialog('close');
    });
    $('#cancel').click(function () {
        $('#txtCommittmentChanges').val(' ');
        $('#committmentDialog').dialog('close');
    });


}

function fancysigninpopup(url, param, autosize) {
    $.fancybox({
    'autoScale': false,
    'autoDimensions': false,
    'transitionIn': 'fade',
    'transitionOut': 'fade',
    'type': 'iframe',
    'scrolling': 'auto',
    'titlePosition': 'over',
    'href': url,
    'width': 580,
    'height': 600,
    'onComplete': function () {
        $('.fancybox-inner').css('width', 20);
        $('.fancybox-wrap').css('width', 40);
        $('.fancybox-skin').css('width', 40);
    }
});
}


$('body').on('click', '.closeDialog', function (e) {
    e.preventDefault();
    $.fancybox.close();
});