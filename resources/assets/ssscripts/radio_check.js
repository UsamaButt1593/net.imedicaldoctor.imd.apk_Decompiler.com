// Radio/Checkbox script to be applied to Lists.

function radioCheck ( target ) {
	// Set the target container var.
	this.target_container = target;
	
	// Insert new Attribute into the 'li' child elements to track their parent
	$( this.target_container + ' li' ).attr( 'myParent', target );
	
	// If the data-max var of the parent is LESS than 2, this is a radio button setup...
	if ( Number( $( this.target_container ).attr( 'data-max' ) ) <= 1 || $( this.target_container ).attr( 'data-max' ) == undefined) {
		$( this.target_container + ' li' ).bind( 'click', function ( e ) {
			$( $( this ).attr( 'myParent' ) + ' li' ).removeClass( 'selected' );
			$( e.currentTarget ).addClass( 'selected' );
            $($( this ).attr( 'myParent' )).attr('data-value', $( e.currentTarget ).attr('data-value'));
                                                
            findAndScrollToParentContainer($($( this ).attr( 'myParent' )).attr('id'));
            valueChanged($($( this ).attr( 'myParent' )).attr('id'));
		});
	} else {
		// This code is for 'Check All That Apply' setup...parent containers with a data-max var of 2 or higher will get this code
		$( this.target_container ).attr( 'curr_clicked', '0' );		
		$( this.target_container + ' li' ).bind( 'click', function ( e ) {
			this.myPar = $(this).attr('myParent');
			if( Number( $( this.myPar ).attr( 'curr_clicked' ) ) < Number( $( this.myPar ).attr( 'data-max' ) ) && !( $( this ).hasClass( 'selected' ) ) ) {
				var inc = Number( $( this.myPar ).attr( 'curr_clicked' ) ) + 1;
				$( this.myPar ).attr( 'curr_clicked', inc );
				$( e.currentTarget ).addClass( 'selected' );
			} else if ( $( this ).hasClass( 'selected' ) ) {
				var dec = Number( $( this.myPar ).attr( 'curr_clicked' ) ) - 1;
				$( this.myPar ).attr( 'curr_clicked', dec );
				$( this ).removeClass( 'selected' );
			}
                                                
            findAndScrollToParentContainer($($( this ).attr( 'myParent' )).attr('id'));
            valueChanged($($( this ).attr( 'myParent' )).attr('id'));
		});
	}
}
