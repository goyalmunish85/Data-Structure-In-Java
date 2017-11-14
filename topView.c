#include<stdio.h>
#include<stdlib.h>
struct tree
{
    int data;
    struct tree *left;
    struct tree *right;
    int val;
};
int a[100];
struct tree *createBST(struct tree *root,int d,int v)
{
    if(root==NULL)
    {
        struct tree *nn = (struct tree *)malloc(sizeof(struct tree));
        nn->data=d;
        nn->val=v;
        nn->left=NULL;
        nn->right=NULL;
        return nn;
    }
    else
    {
        if(d<root->data)
        {
            root->left=createBST(root->left,d,v-1);

        }
        else if(d>root->data)
        {
            root->right=createBST(root->right,d,v+1);
        }
    }
    return root;
}
void printGivenLevel(struct tree* root, int level)
{
    if (root == NULL)
        return;
    if (level == 1)
    {
        printf("%d%d ", root->data,root->val);
        if(a[root->val+50]==NULL)
        {
            a[root->val+50]=root->data;
        }
    }
    else if (level > 1)
    {
        printGivenLevel(root->left, level-1);
        printGivenLevel(root->right, level-1);
    }
}
void printLevelOrder(struct tree* root)
{
    int h = height(root);
    int i;
    for (i=1; i<=h; i++)
    {
        printGivenLevel(root, i);
        printf("\n");
    }
}

int height(struct tree* node)
{
    if (node==NULL)
        return 0;
    else
    {
        int lheight = height(node->left);
        int rheight = height(node->right);
        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
}
void inorder(struct tree *root)
{
    if(root==NULL)
        return;
    inorder(root->left);
    printf("%d",root->data);
    inorder(root->right);
}
int main()
{
    struct tree *root = NULL;
    int i,d,n;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&d);
        root = createBST(root,d,0);
    }
    printLevelOrder(root);
    for(i=0;i<100;i++)
    {
        if(a[i]!=NULL)
            printf("%d ",a[i]);
    }
}
