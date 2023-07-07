import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegularExpression 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		String str="naren";
		
		System.out.println(Pattern.compile("..r.n").matcher(str).matches()); //... mention the character count
		str="naren";
		System.out.println(Pattern.compile("[A-Za-z]+").matcher(str).matches());
		System.out.println(Pattern.compile("[a-z && [^a-e]]*").matcher(str).matches());
		str="narendran3678@gmail.com";
		System.out.println(Pattern.compile("[[\\w]+@[\\s]{5}.[\s]{3}]+").matcher(str).matches());
		ipRegex();
	}
	static void duplicateWord()
	{
		String regex = "Goodbye bye bye world world world";
        Pattern p = Pattern.compile(regex, 0);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll("","");
            }
            
            // Prints the modified sentence.
            System.out.println(input);
           
        }
        
        in.close();
	}
	
	static void ipRegex()
	{
		String str="";
		/*
		    000.12.12.034
			121.234.12.12
			23.45.12.56
			00.12.123.123123.123
			122.23
			Hello.IP
		 */
		String regex	="(\\d{1,2}"
						+ "|(0|1)[\\d]{2}"
						+ "|2[0-4][0-9]"
						+ "|25[0-5])";	
		String pattern  = regex+"\\."+regex+"\\."+regex+"\\."+regex;
	    //pattern  = regex;
		System.out.println("IP Address-"+Pattern.compile(pattern).matcher(str).matches());
	}
	static void StringToken()
	{
		String str="";
		/*str="He is a very very good boy, isn't he?";
		str="           YES      leading spaces        are valid,    problemsetters are         evillllll";
	    str="Good luck with this case!!! h jrkjc c l m e i vct h ss pqk_v i olf tuoej_          p r jrpjpuo a.          udc mu tk g dc,          j o mui brljn!jv p rsklqu p?a lv l n dl quo!cml pld qf l s!          t nb ud j etc q           a j f ugc eer c,          ci de lm p iwk_nwa e su s u ga.l w xlkod f e v_          oo ukaa v t xe.          j cl vmh hi tl!          xa aw ugeibo?c r oo v qte ri,          elbf ibg qk i_m nm s ainis s           u m rhd fgi h v!          mji tu oj t c d.x hxtp a bf xj.          l j ela wuj is           pj gu fs e o v i,s s i b k kab tw@          im c vlud k ki!          e ft gpcf t g k'          m c r snv w b rw,hwoh dfl hn u@cb ep ucsse j_          a d h q p w q rjp_          tln j vofvwg_sj rx pur l dx_          vo b lk sljnm?          k xox i cv va l,          du toe sdwx g@c s uded gw od!          tqsv v t v fnl'          o amka ll x s q_          a frs s ltubs?wdjfdrf x jk.jgkb d s d k n m@sedwkpe ev h_icr ggqxvap@          j g hva o kja q?          j j q ra iak c u!          vqnf thfw wx!          ccn mox sp do'u r ei ifah nl'u g m qipu r c e           ws op hng fbp.          fr vle qh d fv_okcei p e oal_a nsxi g to w x!          qfvv sr cjmo_          kchrkonuc f'ush wd xptas!rfrt o llgwf?          jclpl wmt h r           rv o lhnxnbf           h fqfnla pft?n b uu tbba sl_u ij f i jox xu.ext p gs un dc           fx p o kh rl l j'nkgevg xdrq?          q s wv umu olw?jaidu ilpr e?fc qcr p htpn           g xt d d uqk cp,          cts jkg e i op_j utt rf gvm t!          qgjr r r s cpc,          m n a wde pcg v?e ioek nlc fh@ahk ei ejmp d_fq enmeoesu?          skntwnolsx!j bt bgb dhtt!          r jcl mdh i kr,          m jcl fgix gq_enpuk n g rl i?ei xedl o h e a!x wjp uge h w g'wb dg wlkxli qi x ff eq gbe_bakb m c p aos_vv c m labuj r!          s t oign xwn a@c ffwpic wck_          gmkahnse si!q viev a ndfg,f p utcumoxb'          kgd m n g gnk b!          i rr x x uxx g p_          af s piu hgs o?          kpmrltmrqe@s m mbjfnxq p'          g f i v l wc u ij@";
		 */
	
		String[] arr = str.trim().split("[\\s!@#$%^&*()_',<>?:}{}]+");
		List<String> l=Arrays.asList(arr);
		System.out.println(l.size());
		l.stream().forEach(System.out::println);
		
	}
}
