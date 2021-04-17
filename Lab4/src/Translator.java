public class Translator {

	private String text;

	public Translator(String text) {
		
		this.text=text;		
	}
	
	
	public Translator() {
		// TODO Auto-generated constructor stub
	}


	public void setText(String text) {
		this.text=text;
		
	}
	
	public String getText() {
		return text;
		
	}
		
	
	public String getTranslatedText() {
		
		String newText = "";
				
		if(text.contentEquals("Good Morning")||text.contentEquals("Good morning")||text.contentEquals("good morning")) {
			
		
			newText="Selamat Pagi           الخير صباح         좋은 아침";
	
			}
			
			
		else if (text.contentEquals("Good Night")||text.contentEquals("Good night")||text.contentEquals("good night")) {
			
		
			newText="Selamat malam     مساؤك طاب       안녕히 주무세요";
				
						
			}
			
		else if (text.contentEquals("How are you?")||text.contentEquals("how are you?")) {
			
			
			newText="Apa khabar?          حالكم؟ كيف         어떻게 지내세요?";
				
		
			}
		
	    else if (text.contentEquals("Thank you")||text.contentEquals("thank you")) {
		
	    	newText="Terima kasih     لكي شكرا       감사합니다";
		
			}
		
		else if (text.contentEquals("Goodbye")||text.contentEquals("goodbye") ||text.contentEquals("good bye")) {
			
		
			newText="Selamat Tinggal    السلامة مع           안녕";
				
		
			}
			
		else if (text.contentEquals("What's up?")||text.contentEquals("what's up?")) {
			
			
			newText="Ada apa?          أخبارك؟ ما       뭐야?";
						
			}
		else {
			newText= "-------Translation not available-----";
		}
		
		return newText;
	
	  }

}