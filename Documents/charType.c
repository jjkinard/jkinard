//charType.c
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include<assert.h>
#define MAX_STRING_LENGTH 100

void extract_chars(char*s, char* a, char* d, char* p, char* w);

int main(int argc, char* argv[]){
	//taken from alphaNum.c split alpha_num, & created punct, space, lineNumber 
	FILE* in;
	FILE* out;
	char* line;
	char* alpha;
	char* number;
	char* punct;
	char* space;
	int lineNumber=1;
	
   // check command line for correct number of arguments 
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }
	
   // open input file for reading 
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing 
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }
   line= calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   alpha= calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   number= calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   punct= calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   space= calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   assert( line !=NULL && alpha !=NULL && number!=NULL && punct !=NULL && space !=NULL);
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
      extract_chars(line, alpha, number, punct, space);
      fprintf(out, "line %d contains: \n", lineNumber);
   
	if(strlen(alpha)>1){
		fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(alpha), alpha);
	}else{
		fprintf(out, "%d alphabetic character:%s\n", (int)strlen(alpha), alpha);
	}
   
	if(strlen(number)>1){
		fprintf(out, "%d numeric characters:%s\n", (int)strlen(number), number);   
	}else{
			fprintf(out, "%d numeric character%s\n", (int)strlen(number), number);
	}
	
	if(strlen(punct)>1){
		fprintf(out, "%d punctuation characters:%s\n", (int)strlen(punct), punct);
	}else{
		fprintf(out, "%d punctuation character:%s\n", (int)strlen(punct), punct);
	}
   
	if(strlen(space)>1){
		fprintf(out, "%d whitespace characters:%s\n", (int)strlen(space), space);
	}else{
		fprintf(out, "%d whitespace character:%s\n", (int)strlen(space), space);
	}
	lineNumber++;
   }
   // free heap memory 
   free(line);
   free(alpha);
   free(number);
   free(punct);
   free(space);

   // close input and output files 
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
}

void extract_chars(char*s, char* a, char* d, char* p, char* w){
	int i=0;
	int aa=0;
	int dd=0;
	int pp=0;
	int ww=0;

	while(s[i]!='\0' && i<MAX_STRING_LENGTH){
		if(isalpha((int)s[i])){
			a[aa]=s[i];
			aa++;
		}else if (isdigit((int)s[i])){
			d[dd]=s[i];
			dd++;
		}else if(ispunct((int)s[i])){
			p[pp]=s[i];
			pp++;
		}else{
			w[ww]=s[i];
			ww++;
		}
	i++;
	}
	a[aa] = '\0';
	d[dd] = '\0';
	p[pp] = '\0';
	w[ww] = '\0';
}